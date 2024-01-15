package com.example.cuadricula.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @DrawableRes val image: Int,
    @StringRes val text: Int,
    val followersNumber: Int
)
