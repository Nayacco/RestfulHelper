package com.github.nayacco.restfulhelper.contributor

import com.github.nayacco.restfulhelper.RequestMappingItem
import com.github.nayacco.restfulhelper.annotations.MappingAnnotation.Companion.mappingAnnotation
import com.github.nayacco.restfulhelper.annotations.MappingAnnotation.Companion.supportedAnnotations
import com.github.nayacco.restfulhelper.annotations.jakartars.JAKARTARS_PACKAGE_NAME
import com.github.nayacco.restfulhelper.annotations.jaxrs.JAXRS_PACKAGE_NAME
import com.github.nayacco.restfulhelper.annotations.micronaut.MICRONAUT_PACKAGE_NAME
import com.github.nayacco.restfulhelper.annotations.spring.SPRING_PACKAGE_NAME
import com.github.nayacco.restfulhelper.utils.isMethodAnnotation
import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiAnnotation

abstract class RequestMappingByNameContributor(
    private var navigationItems: List<RequestMappingItem> = emptyList()
) : ChooseByNameContributor {

    abstract fun getAnnotationSearchers(annotationName: String, project: Project): Sequence<PsiAnnotation>

    override fun getNames(project: Project, includeNonProjectItems: Boolean): Array<String> {
        navigationItems = supportedAnnotations
            .flatMap { annotation -> findRequestMappingItems(project, annotation) }

        return navigationItems
            .map { it.name }
            .distinct()
            .toTypedArray()
    }

    override fun getItemsByName(name: String, pattern: String, project: Project, includeNonProjectItems: Boolean): Array<NavigationItem> {
        return navigationItems
            .filter { it.name == name }
            .toTypedArray()
    }

    private fun findRequestMappingItems(project: Project, annotationName: String): List<RequestMappingItem> {
        return getAnnotationSearchers(annotationName, project)
            .filter { it.isMethodAnnotation() }
            .filter {
                it.qualifiedName!!.contains(MICRONAUT_PACKAGE_NAME)
                        || it.qualifiedName!!.contains(SPRING_PACKAGE_NAME)
                        || it.qualifiedName!!.contains(JAXRS_PACKAGE_NAME)
                        || it.qualifiedName!!.contains(JAKARTARS_PACKAGE_NAME)
            }
            .map { annotation -> mappingAnnotation(annotationName, annotation) }
            .flatMap { mappingAnnotation -> mappingAnnotation.values().asSequence() }
            .toList()
    }
}
