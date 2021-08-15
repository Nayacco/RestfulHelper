package com.github.goldsubmarine.restfulhelper.annotations

import com.github.goldsubmarine.restfulhelper.RequestMappingItem

object UnknownAnnotation : MappingAnnotation {
    private val mappingItems = emptyList<RequestMappingItem>()
    override fun values(): List<RequestMappingItem> = mappingItems
}
