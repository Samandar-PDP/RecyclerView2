package com.example.recyclerview2.model

import androidx.annotation.DrawableRes

data class Grid(
    @DrawableRes val image: Int,
    val textName: String
): java.io.Serializable
