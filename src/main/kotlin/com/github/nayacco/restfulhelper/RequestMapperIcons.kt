package com.github.nayacco.restfulhelper

import com.intellij.openapi.util.IconLoader

object RequestMapperIcons {
    val SEARCH = IconLoader.getIcon("/icons/search.png", RequestMapperIcons::class.java)

    // HTTP method-specific icons
    val GET = IconLoader.getIcon("/icons/method_get.svg", RequestMapperIcons::class.java)
    val POST = IconLoader.getIcon("/icons/method_post.svg", RequestMapperIcons::class.java)
    val PUT = IconLoader.getIcon("/icons/method_put.svg", RequestMapperIcons::class.java)
    val DELETE = IconLoader.getIcon("/icons/method_delete.svg", RequestMapperIcons::class.java)
    val PATCH = IconLoader.getIcon("/icons/method_patch.svg", RequestMapperIcons::class.java)
    val DEFAULT = IconLoader.getIcon("/icons/method_default.svg", RequestMapperIcons::class.java)
}
