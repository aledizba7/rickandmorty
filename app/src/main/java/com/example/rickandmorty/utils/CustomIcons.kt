package com.example.rickandmorty.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val CircleFilled: ImageVector
    get() {
        if (_CircleFilled != null) {
            return _CircleFilled!!
        }
        _CircleFilled = ImageVector.Builder(
            name = "CircleFilled",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(8f, 4f)
                curveToRelative(0.367f, 0f, 0.721f, 0.048f, 1.063f, 0.145f)
                arcToRelative(3.943f, 3.943f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1.762f, 1.031f)
                arcToRelative(3.944f, 3.944f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1.03f, 1.762f)
                curveToRelative(0.097f, 0.34f, 0.145f, 0.695f, 0.145f, 1.062f)
                curveToRelative(0f, 0.367f, -0.048f, 0.721f, -0.145f, 1.063f)
                arcToRelative(3.94f, 3.94f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.03f, 1.765f)
                arcToRelative(4.017f, 4.017f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.762f, 1.031f)
                curveTo(8.72f, 11.953f, 8.367f, 12f, 8f, 12f)
                reflectiveCurveToRelative(-0.721f, -0.047f, -1.063f, -0.14f)
                arcToRelative(4.056f, 4.056f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.765f, -1.032f)
                arcTo(4.055f, 4.055f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4.14f, 9.062f)
                arcTo(3.992f, 3.992f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 8f)
                curveToRelative(0f, -0.367f, 0.047f, -0.721f, 0.14f, -1.063f)
                arcToRelative(4.02f, 4.02f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.407f, -0.953f)
                arcTo(4.089f, 4.089f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.98f, 4.546f)
                arcToRelative(3.94f, 3.94f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.957f, -0.401f)
                arcTo(3.89f, 3.89f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 4f)
                close()
            }
        }.build()
        return _CircleFilled!!
    }

private var _CircleFilled: ImageVector? = null
