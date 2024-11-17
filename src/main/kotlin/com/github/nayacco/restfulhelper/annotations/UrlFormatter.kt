package com.github.nayacco.restfulhelper.annotations

interface UrlFormatter {

    fun format(classMapping: String, methodMapping: String, param: String = ""): String
}
