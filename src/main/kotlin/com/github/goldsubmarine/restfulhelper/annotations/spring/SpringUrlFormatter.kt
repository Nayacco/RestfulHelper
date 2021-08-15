package com.github.goldsubmarine.restfulhelper.annotations.spring

import com.github.goldsubmarine.restfulhelper.annotations.UrlFormatter
import com.github.goldsubmarine.restfulhelper.utils.dropFirstEmptyStringIfExists

object SpringUrlFormatter : UrlFormatter {

    override fun format(classMapping: String, methodMapping: String, param: String): String {
        val classPathSeq = classMapping.splitToSequence('/').filterNot { it.isBlank() }
        val methodPathList = methodMapping.split('/').dropFirstEmptyStringIfExists()
        val path = (classPathSeq + methodPathList).joinToString(separator = "/", prefix = "/").replace("\${", "{")
        return path + if (param.isNotBlank()) " params=$param" else ""
    }
}
