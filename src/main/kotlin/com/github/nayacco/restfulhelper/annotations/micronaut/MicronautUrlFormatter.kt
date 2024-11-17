package com.github.nayacco.restfulhelper.annotations.micronaut

import com.github.nayacco.restfulhelper.annotations.UrlFormatter
import com.github.nayacco.restfulhelper.utils.dropFirstEmptyStringIfExists

object MicronautUrlFormatter : UrlFormatter {

    override fun format(classMapping: String, methodMapping: String, param: String): String {
        val classPathSeq = classMapping.splitToSequence('/').filterNot { it.isBlank() }
        val methodPathList = methodMapping.split('/').dropFirstEmptyStringIfExists()
        return (classPathSeq + methodPathList).joinToString(separator = "/", prefix = "/")
    }
}
