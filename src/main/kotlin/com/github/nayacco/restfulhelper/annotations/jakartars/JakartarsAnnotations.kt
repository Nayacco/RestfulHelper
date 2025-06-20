package com.github.nayacco.restfulhelper.annotations.jakartars

import com.intellij.psi.PsiAnnotation

const val JAKARTARS_PACKAGE_NAME = "jakarta.ws.rs"

class JakartaGet(psiAnnotation: PsiAnnotation) : JakartaRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "GET"
}
class JakartaDelete(psiAnnotation: PsiAnnotation) : JakartaRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "DELETE"
}
class JakartaHead(psiAnnotation: PsiAnnotation) : JakartaRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "HEAD"
}
class JakartaOptions(psiAnnotation: PsiAnnotation) : JakartaRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "OPTIONS"
}
class JakartaPatch(psiAnnotation: PsiAnnotation) : JakartaRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PATCH"
}
class JakartaPost(psiAnnotation: PsiAnnotation) : JakartaRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "POST"
}
class JakartaPut(psiAnnotation: PsiAnnotation) : JakartaRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PUT"
}