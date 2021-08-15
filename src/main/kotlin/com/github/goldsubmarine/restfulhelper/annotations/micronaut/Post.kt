package com.github.goldsubmarine.restfulhelper.annotations.micronaut

import com.intellij.psi.PsiAnnotation

class Post(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {

    override fun extractMethod() = METHOD

    companion object {
        private const val METHOD = "POST"
    }
}
