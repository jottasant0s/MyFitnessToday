package com.example.myfitnesstoday

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DashboardItem(
    val id: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val TextStringId: Int
)
