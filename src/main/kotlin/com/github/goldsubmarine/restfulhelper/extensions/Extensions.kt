package com.github.goldsubmarine.restfulhelper.extensions

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.openapi.extensions.ExtensionPointName

object Extensions {

    private const val EXTENSION_POINT_NAME = "com.github.goldsubmarine.restfulhelper.requestMappingContributor"
    private val extensionPoints = ExtensionPointName.create<ChooseByNameContributor>(EXTENSION_POINT_NAME)

    fun getExtensions(): List<ChooseByNameContributor> {
        return extensionPoints.extensionList
    }
}
