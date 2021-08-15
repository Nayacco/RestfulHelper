package com.github.goldsubmarine.restfulhelper.annotations.jaxrs

import com.intellij.psi.PsiAnnotation

class DELETE(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {

    override fun extractMethod() = METHOD

    companion object {
        private const val METHOD = "DELETE"
    }
}
