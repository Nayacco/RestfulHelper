package com.github.goldsubmarine.restfulhelper.annotations.jaxrs

import com.intellij.psi.PsiAnnotation

class GET(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "GET"
}
class DELETE(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "DELETE"
}
class HEAD(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "HEAD"
}
class OPTIONS(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "OPTIONS"
}
class PATCH(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PATCH"
}
class POST(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "POST"
}
class PUT(psiAnnotation: PsiAnnotation) : JaxRsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PUT"
}