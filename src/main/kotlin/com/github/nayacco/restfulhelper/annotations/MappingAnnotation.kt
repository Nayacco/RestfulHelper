package com.github.nayacco.restfulhelper.annotations

import com.github.nayacco.restfulhelper.RequestMappingItem
import com.github.nayacco.restfulhelper.annotations.jakartars.*
import com.github.nayacco.restfulhelper.annotations.jaxrs.*
import com.github.nayacco.restfulhelper.annotations.micronaut.*
import com.github.nayacco.restfulhelper.annotations.spring.*
import com.intellij.psi.PsiAnnotation

interface MappingAnnotation {

    fun values(): List<RequestMappingItem>

    companion object {
        val supportedAnnotations = listOf(
            RequestMapping::class.java.simpleName,
            GetMapping::class.java.simpleName,
            PostMapping::class.java.simpleName,
            PutMapping::class.java.simpleName,
            PatchMapping::class.java.simpleName,
            DeleteMapping::class.java.simpleName,

            GET::class.java.simpleName,
            PUT::class.java.simpleName,
            POST::class.java.simpleName,
            OPTIONS::class.java.simpleName,
            HEAD::class.java.simpleName,
            DELETE::class.java.simpleName,
            PATCH::class.java.simpleName,

            Delete::class.java.simpleName,
            Get::class.java.simpleName,
            Head::class.java.simpleName,
            Options::class.java.simpleName,
            Patch::class.java.simpleName,
            Post::class.java.simpleName,
            Put::class.java.simpleName
        )

        fun mappingAnnotation(annotationName: String, psiAnnotation: PsiAnnotation): MappingAnnotation {
            val isJakartaPackage = psiAnnotation.qualifiedName!!.contains(JAKARTARS_PACKAGE_NAME)
            return when (annotationName) {
                RequestMapping::class.java.simpleName -> RequestMapping(psiAnnotation)
                GetMapping::class.java.simpleName -> GetMapping(psiAnnotation)
                PostMapping::class.java.simpleName -> PostMapping(psiAnnotation)
                PutMapping::class.java.simpleName -> PutMapping(psiAnnotation)
                PatchMapping::class.java.simpleName -> PatchMapping(psiAnnotation)
                DeleteMapping::class.java.simpleName -> DeleteMapping(psiAnnotation)

                GET::class.java.simpleName -> if (isJakartaPackage) JakartaGet(psiAnnotation) else GET(psiAnnotation)
                PUT::class.java.simpleName -> if (isJakartaPackage) JakartaPut(psiAnnotation) else PUT(psiAnnotation)
                POST::class.java.simpleName -> if (isJakartaPackage) JakartaPost(psiAnnotation) else POST(psiAnnotation)
                OPTIONS::class.java.simpleName -> if (isJakartaPackage) JakartaOptions(psiAnnotation) else OPTIONS(psiAnnotation)
                HEAD::class.java.simpleName -> if (isJakartaPackage) JakartaHead(psiAnnotation) else HEAD(psiAnnotation)
                DELETE::class.java.simpleName -> if (isJakartaPackage) JakartaDelete(psiAnnotation) else DELETE(psiAnnotation)
                PATCH::class.java.simpleName -> if (isJakartaPackage) JakartaPatch(psiAnnotation) else PATCH(psiAnnotation)

                Get::class.java.simpleName -> Get(psiAnnotation)
                Put::class.java.simpleName -> Put(psiAnnotation)
                Post::class.java.simpleName -> Post(psiAnnotation)
                Options::class.java.simpleName -> Options(psiAnnotation)
                Head::class.java.simpleName -> Head(psiAnnotation)
                Delete::class.java.simpleName -> Delete(psiAnnotation)
                Patch::class.java.simpleName -> Patch(psiAnnotation)

                else -> UnknownAnnotation
            }
        }
    }
}
