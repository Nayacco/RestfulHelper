package com.github.nayacco.restfulhelper.annotations.ws

import com.intellij.psi.PsiAnnotation

const val JAVAX_WS_PACKAGE = "javax.ws.rs"
const val JAKARTA_WS_PACKAGE = "jakarta.ws.rs"

class GET(psiAnnotation: PsiAnnotation) : WsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "GET"
}
class DELETE(psiAnnotation: PsiAnnotation) : WsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "DELETE"
}
class HEAD(psiAnnotation: PsiAnnotation) : WsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "HEAD"
}
class OPTIONS(psiAnnotation: PsiAnnotation) : WsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "OPTIONS"
}
class PATCH(psiAnnotation: PsiAnnotation) : WsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PATCH"
}
class POST(psiAnnotation: PsiAnnotation) : WsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "POST"
}
class PUT(psiAnnotation: PsiAnnotation) : WsMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PUT"
}
