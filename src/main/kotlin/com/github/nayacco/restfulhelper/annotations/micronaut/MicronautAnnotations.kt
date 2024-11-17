package com.github.nayacco.restfulhelper.annotations.micronaut

import com.intellij.psi.PsiAnnotation

const val MICRONAUT_PACKAGE_NAME = "io.micronaut.http.annotation"

class Delete(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "DELETE"
}
class Get(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "GET"
}
class Head(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "HEAD"
}
class Options(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "OPTIONS"
}
class Patch(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PATCH"
}
class Post(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "POST"
}
class Put(psiAnnotation: PsiAnnotation) : MicronautMappingAnnotation(psiAnnotation) {
    override fun extractMethod() = "PUT"
}