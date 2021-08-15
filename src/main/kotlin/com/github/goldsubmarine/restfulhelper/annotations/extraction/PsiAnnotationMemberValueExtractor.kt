package com.github.goldsubmarine.restfulhelper.annotations.extraction

import com.intellij.psi.PsiAnnotationMemberValue
import com.github.goldsubmarine.restfulhelper.annotations.extraction.PsiExpressionExtractor.extractExpression
import com.github.goldsubmarine.restfulhelper.utils.unquote

class PsiAnnotationMemberValueExtractor : PsiAnnotationValueExtractor<PsiAnnotationMemberValue> {

    override fun extract(value: PsiAnnotationMemberValue): List<String> {
        val element = extractExpression(value)
        return when {
            element.isNotBlank() -> listOf(element)
            value.text.isNotBlank() -> listOf(value.text.unquote())
            else -> emptyList()
        }
    }
}
