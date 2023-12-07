package com.github.goldsubmarine.restfulhelper

import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import java.util.concurrent.atomic.AtomicReference

class RequestMappingItem(val psiElement: PsiElement, private val urlPath: String, private val requestMethod: String) : NavigationItem {

    private val navigationElement = psiElement.navigationElement as? Navigatable

    override fun getName(): String = this.requestMethod + " " + this.urlPath

    override fun getPresentation(): ItemPresentation = RequestMappingItemPresentation()

    override fun navigate(requestFocus: Boolean) = navigationElement?.navigate(requestFocus) ?: Unit

    override fun canNavigate(): Boolean = navigationElement?.canNavigate() ?: false

    override fun canNavigateToSource(): Boolean = true

    override fun toString(): String {
        return "RequestMappingItem(psiElement=$psiElement, urlPath='$urlPath', requestMethod='$requestMethod', navigationElement=$navigationElement)"
    }

    internal inner class RequestMappingItemPresentation : ItemPresentation {

        override fun getPresentableText() = this@RequestMappingItem.requestMethod + " " + this@RequestMappingItem.urlPath

        override fun getLocationString(): String {
            val psiElement = this@RequestMappingItem.psiElement
            val fileName = psiElement.containingFile?.name
            return when (psiElement) {
                is PsiMethod -> (psiElement.containingClass?.name ?: fileName ?: "unknownFile") + "." + psiElement.name + getPresentModuleName()
                is PsiClass -> psiElement.name ?: fileName ?: "unknownFile" + getPresentModuleName()
                else -> "unknownLocation"
            }
        }

        override fun getIcon(b: Boolean) = RequestMapperIcons.SEARCH

        private fun getPresentModuleName(): String {
            val moduleName = getModuleName()
            if (moduleName.isEmpty()) {
                return ""
            }
            val names = moduleName.split(""".""")
            return " (" + if (names.size >= 2) { names[names.size - 2].uppercase() } else { names[0].uppercase() } + ")"
        }

        private fun getModuleName(): String {
            val result: AtomicReference<String> = AtomicReference()

            ApplicationManager.getApplication().runReadAction {
                val element = this@RequestMappingItem.psiElement
                val file = element.containingFile.originalFile.virtualFile
                val module = ProjectRootManager.getInstance(element.project).fileIndex.getModuleForFile(file)
                result.set(module?.name ?: "")
            }

            return result.get()
        }
    }
}
