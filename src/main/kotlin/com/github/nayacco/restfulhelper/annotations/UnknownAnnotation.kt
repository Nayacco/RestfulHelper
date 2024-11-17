package com.github.nayacco.restfulhelper.annotations

import com.github.nayacco.restfulhelper.RequestMappingItem

object UnknownAnnotation : MappingAnnotation {
    private val mappingItems = emptyList<RequestMappingItem>()
    override fun values(): List<RequestMappingItem> = mappingItems
}
