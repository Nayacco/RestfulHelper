package com.github.goldsubmarine.restfulhelper.annotations.extraction

import com.intellij.psi.PsiBinaryExpression
import com.github.goldsubmarine.restfulhelper.annotations.extraction.PsiExpressionExtractor.extractExpression

class PsiBinaryExpressionExtractor : PsiAnnotationValueExtractor<PsiBinaryExpression> {

    override fun extract(value: PsiBinaryExpression) =
        listOf(extractExpression(value.lOperand) + extractExpression(value.rOperand!!))
}
