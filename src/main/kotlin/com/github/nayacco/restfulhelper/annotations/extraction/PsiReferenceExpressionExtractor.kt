package com.github.nayacco.restfulhelper.annotations.extraction

import com.intellij.psi.PsiReferenceExpression
import com.github.nayacco.restfulhelper.annotations.extraction.PsiExpressionExtractor.extractExpression

class PsiReferenceExpressionExtractor : PsiAnnotationValueExtractor<PsiReferenceExpression> {

    override fun extract(value: PsiReferenceExpression): List<String> = listOf(extractExpression(value))
}
