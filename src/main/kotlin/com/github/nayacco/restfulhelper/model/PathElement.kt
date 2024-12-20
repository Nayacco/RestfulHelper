package com.github.nayacco.restfulhelper.model

import com.github.nayacco.restfulhelper.utils.addCurlyBrackets
import com.github.nayacco.restfulhelper.utils.inCurlyBrackets
import com.github.nayacco.restfulhelper.utils.isNumeric
import com.github.nayacco.restfulhelper.utils.unquoteCurlyBrackets
import org.apache.commons.text.StringEscapeUtils

class PathElement(val value: String) {
    val isPathVariable: Boolean = value.inCurlyBrackets()

    fun addPathVariableType(type: String) = if (isPathVariable) PathElement(value.unquoteCurlyBrackets().let { "${type.ifBlank { "String" }}:$it" }.addCurlyBrackets())
    else this

    private fun compareWithPathVariable(pathElement: PathElement, searchPattern: PathElement): Boolean =
        if (pathElement.isPathVariable && searchPattern.isPathVariable) {
            comparePathVariables(searchPattern, pathElement)
        } else {
            compareSearchElementWithPathElement(searchPattern, pathElement)
        }

    private fun comparePathVariables(searchPattern: PathElement, pathElement: PathElement): Boolean {
        val searchPatternValue = StringEscapeUtils.unescapeJava(searchPattern.value.unquoteCurlyBrackets().substringAfterLast(':'))
        val pathElementValue = StringEscapeUtils.unescapeJava(pathElement.value.unquoteCurlyBrackets().substringAfterLast(':'))
        return pathElementValue.contains(searchPatternValue)
    }

    private fun compareSearchElementWithPathElement(searchPattern: PathElement, pathElement: PathElement): Boolean {
        if (pathElement.value.count { it == ':' } > 1) {
            val regexString = StringEscapeUtils.unescapeJava(pathElement.value.unquoteCurlyBrackets().substringAfterLast(':'))
            return regexString.toRegex().matches(searchPattern.value)
        }
        val bothAreNumbers = isDigit(pathElement.value) && searchPattern.value.isNumeric()
        val pathVariableIsNotNumber = !isDigit(pathElement.value)
        return bothAreNumbers || pathVariableIsNotNumber
    }

    /**
     * Format of curly brackets values:
     * String:items
     * Int:itemId
     * Long:itemId
     */
    private fun isDigit(originalElement: String) = when (originalElement.unquoteCurlyBrackets().split(":").first()) {
        "int" -> true
        "long" -> true
        "float" -> true
        "double" -> true

        "Integer" -> true
        "Long" -> true
        "Float" -> true
        "Double" -> true

        "BigInteger" -> true
        "BigDecimal" -> true

        else -> false
    }

    fun compareToSearchPattern(searchPattern: PathElement): Boolean {
        if (!this.isPathVariable && !searchPattern.isPathVariable) return value == searchPattern.value
        if (!this.isPathVariable && searchPattern.isPathVariable) return false
        return compareWithPathVariable(this, searchPattern)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PathElement

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
