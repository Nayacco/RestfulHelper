package com.github.goldsubmarine.restfulhelper.annotations

interface UrlFormatter {

    fun format(classMapping: String, methodMapping: String, param: String = ""): String
}
