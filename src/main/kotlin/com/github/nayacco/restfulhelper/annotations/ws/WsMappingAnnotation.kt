package com.github.nayacco.restfulhelper.annotations.ws

import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiReferenceExpression
import com.github.nayacco.restfulhelper.RequestMappingItem
import com.github.nayacco.restfulhelper.annotations.MappingAnnotation
import com.github.nayacco.restfulhelper.annotations.PathAnnotation
import com.github.nayacco.restfulhelper.annotations.UrlFormatter
import com.github.nayacco.restfulhelper.annotations.extraction.PsiExpressionExtractor.extractExpression
import com.github.nayacco.restfulhelper.model.Path
import com.github.nayacco.restfulhelper.model.PathParameter
import com.github.nayacco.restfulhelper.utils.fetchAnnotatedMethod

abstract class WsMappingAnnotation(
    private val psiAnnotation: PsiAnnotation,
    private val urlFormatter: UrlFormatter = WsUrlFormatter
) : MappingAnnotation {

    // psiAnnotation의 qualifiedName에서 javax/jakarta 네임스페이스를 자동 감지
    private val namespace: String = detectNamespace()
    private val pathAnnotation: String = "$namespace.Path"
    private val pathParamAnnotation: String = "$namespace.PathParam"

    override fun values(): List<RequestMappingItem> =
        fetchRequestMappingItem(psiAnnotation.fetchAnnotatedMethod(), extractMethod())

    abstract fun extractMethod(): String

    private fun fetchRequestMappingItem(psiMethod: PsiMethod, method: String): List<RequestMappingItem> {
        val classMapping = fetchMappingFromClass(psiMethod)
        val methodMapping = fetchMappingFromMethod(psiMethod)
        return listOf(RequestMappingItem(psiMethod, urlFormatter.format(classMapping, methodMapping), method))
    }

    private fun fetchMappingFromClass(psiMethod: PsiMethod): String {
        return psiMethod
            .containingClass
            ?.modifierList
            ?.annotations
            ?.filter { it.qualifiedName == pathAnnotation }
            ?.flatMap { PathAnnotation(it).fetchMappings(ATTRIBUTE_NAME) }
            ?.firstOrNull() ?: ""
    }

    private fun fetchMappingFromMethod(method: PsiMethod): String {
        val parametersNameWithType = method
            .parameterList
            .parameters
            .mapNotNull { PathParameter(it).extractParameterNameWithType(pathParamAnnotation, ::extractParameterNameFromAnnotation) }
            .toMap()

        return method
            .modifierList
            .annotations
            .filter { it.qualifiedName == pathAnnotation }
            .flatMap { PathAnnotation(it).fetchMappings(ATTRIBUTE_NAME) }
            .map { Path(it).addPathVariablesTypes(parametersNameWithType).toFullPath() }
            .firstOrNull() ?: ""
    }

    private fun extractParameterNameFromAnnotation(annotation: PsiAnnotation, defaultValue: String): String {
        return when (val pathVariableValue = annotation.findAttributeValue(ATTRIBUTE_NAME)) {
            is PsiLiteralExpression -> {
                val expression = extractExpression(pathVariableValue)
                expression.ifBlank { defaultValue }
            }
            is PsiReferenceExpression -> {
                val expression = extractExpression(pathVariableValue)
                expression.ifBlank { defaultValue }
            }
            else -> defaultValue
        }
    }

    // 어노테이션의 FQCN 접두사로 jakarta/javax 네임스페이스를 판별
    private fun detectNamespace(): String {
        val qn = psiAnnotation.qualifiedName ?: return JAVAX_WS_PACKAGE
        return if (qn.startsWith("jakarta.")) JAKARTA_WS_PACKAGE else JAVAX_WS_PACKAGE
    }

    companion object {
        private const val ATTRIBUTE_NAME = "value"
    }
}
