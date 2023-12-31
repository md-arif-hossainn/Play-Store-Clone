package com.arif.playstoredesign.utils

import android.content.Context
import android.widget.ImageView
import com.arif.playstoredesign.R
import com.bumptech.glide.Glide

fun Context.setImage(view: ImageView,drawableImage: Int) {
    Glide
        .with(this)
        .asGif()
        .load(drawableImage)
        .into(view)
}

fun Context.setImage(view: ImageView,imageUrl: String) {
    Glide
        .with(this)
        .asGif()
        .load(imageUrl)
        .into(view)
}