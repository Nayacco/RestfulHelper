package com.github.goldsubmarine.restfulhelper.contributor

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.impl.java.stubs.index.JavaAnnotationIndex
import com.intellij.psi.search.GlobalSearchScope

class JavaRequestMappingContributor : RequestMappingByNameContributor() {

    override fun getAnnotationSearchers(annotationName: String, project: Project): Sequence<PsiAnnotation> {
        return JavaAnnotationIndex
            .getInstance()
            .getAnnotations(annotationName, project, GlobalSearchScope.projectScope(project))
            .asSequence()
    }
}
