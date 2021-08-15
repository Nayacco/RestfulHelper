package com.github.goldsubmarine.restfulhelper.annotations.spring

import com.intellij.psi.PsiAnnotation

class PutMapping(psiAnnotation: PsiAnnotation) : RequestMapping(psiAnnotation) {

    override fun extractMethod() = METHOD

    companion object {
        private const val METHOD = "PUT"
    }
}
