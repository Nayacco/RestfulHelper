package com.github.nayacco.restfulhelper.extensions

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.openapi.extensions.ExtensionPointName

object Extensions {

    private const val EXTENSION_POINT_NAME = "com.github.nayacco.restfulhelper.requestMappingContributor"
    private val extensionPoints = ExtensionPointName.create<ChooseByNameContributor>(EXTENSION_POINT_NAME)

    fun getExtensions(): List<ChooseByNameContributor> {
        return extensionPoints.extensionList
    }
}
