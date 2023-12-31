package com.arif.playstoredesign.data_model

data class RowAppDataModel(
    val id: Int = 1,
    val appPoster:Int,
    val name: String,
    val hideDivider: Boolean = true
)

data class ViewTypeDataModel(
    val appPoster1: Int,
    val appPoster2: Int?,
    val appPoster3: Int?,
    val mainPoster: Int
)
data class TwoPosterDataModel(
    val appPoster1: Int,
    val mainPoster: Int,
    val name:String
)

data class ThreePosterDataModel(
    val appPoster1: Int,
    val appPoster1Name: String,
    val appPoster2: Int,
    val appPoster2Name: String,
    val appPoster3: Int,
    val appPoster3Name: String,



    )
