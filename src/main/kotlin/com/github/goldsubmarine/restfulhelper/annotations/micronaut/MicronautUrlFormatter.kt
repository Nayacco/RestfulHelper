package com.github.goldsubmarine.restfulhelper.annotations.micronaut

import com.github.goldsubmarine.restfulhelper.annotations.UrlFormatter
import com.github.goldsubmarine.restfulhelper.utils.dropFirstEmptyStringIfExists

object MicronautUrlFormatter : UrlFormatter {

    override fun format(classMapping: String, methodMapping: String, param: String): String {
        val classPathSeq = classMapping.splitToSequence('/').filterNot { it.isBlank() }
        val methodPathList = methodMapping.split('/').dropFirstEmptyStringIfExists()
        return (classPathSeq + methodPathList).joinToString(separator = "/", prefix = "/")
    }
}
