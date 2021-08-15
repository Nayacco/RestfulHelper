package com.github.goldsubmarine.restfulhelper.annotations.jaxrs

import com.intellij.psi.PsiAnnotation

class GET(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {

    override fun extractMethod() = METHOD

    companion object {
        private const val METHOD = "GET"
    }
}
