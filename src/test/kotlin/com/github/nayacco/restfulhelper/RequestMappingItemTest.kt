package com.github.nayacco.restfulhelper

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.FakePsiElement
import org.junit.Assert.assertEquals
import org.junit.Test

class RequestMappingItemTest {

    @Test
    fun `presentation text should show only url path`() {
        val item = RequestMappingItem(
            psiElement = object : FakePsiElement() {
                override fun getParent(): PsiElement? = null
            },
            urlPath = "/users",
            requestMethod = "GET",
        )

        assertEquals("/users", item.presentation.presentableText)
    }
}
