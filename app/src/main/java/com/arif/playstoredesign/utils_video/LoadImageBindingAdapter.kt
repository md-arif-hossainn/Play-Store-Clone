package com.arif.playstoredesign.utils_video

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.arif.playstoredesign.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class LoadImageBindingAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter(value = ["thumbnail", "error"], requireAll = false)
        fun loadImage(view: ImageView, profileImage: String?, error: Int) {
            if (!profileImage.isNullOrEmpty()) {
                Glide.with(view.context)
                    .setDefaultRequestOptions(
                        RequestOptions()
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.loading))
                    .load(profileImage)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(view)
            }
        }
    }
}