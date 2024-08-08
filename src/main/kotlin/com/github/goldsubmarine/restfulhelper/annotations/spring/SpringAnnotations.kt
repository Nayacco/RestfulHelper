package com.github.goldsubmarine.restfulhelper.annotations.spring

import com.intellij.psi.PsiAnnotation

const val SPRING_PACKAGE_NAME = "org.springframework.web.bind.annotation"

class DeleteMapping(psiAnnotation: PsiAnnotation) : RequestMapping(psiAnnotation) {
    override fun extractMethod() = "DELETE"
}
class GetMapping(psiAnnotation: PsiAnnotation) : RequestMapping(psiAnnotation) {
    override fun extractMethod() = "GET"
}
class PatchMapping(psiAnnotation: PsiAnnotation) : RequestMapping(psiAnnotation) {
    override fun extractMethod() = "PATCH"
}
class PostMapping(psiAnnotation: PsiAnnotation) : RequestMapping(psiAnnotation) {
    override fun extractMethod() = "POST"
}
class PutMapping(psiAnnotation: PsiAnnotation) : RequestMapping(psiAnnotation) {
    override fun extractMethod() = "PUT"
}

open class RequestMapping(psiAnnotation: PsiAnnotation) : SpringMappingAnnotation(psiAnnotation) {
    override fun extractMethod(): String {
        val valueParam = psiAnnotation.findAttributeValue("method")
        if (valueParam != null && valueParam.text.isNotBlank() && "{}" != valueParam.text) {
            return valueParam.text.replace("RequestMethod.", "")
        }
        return "GET"
    }
}