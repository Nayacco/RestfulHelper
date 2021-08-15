package com.github.goldsubmarine.restfulhelper.annotations.extraction

import com.intellij.psi.PsiPolyadicExpression
import com.github.goldsubmarine.restfulhelper.annotations.extraction.PsiExpressionExtractor.extractExpression

class PsiPolyadicExpressionExtractor : PsiAnnotationValueExtractor<PsiPolyadicExpression> {

    override fun extract(value: PsiPolyadicExpression) = listOf(extractExpression(value))
}
