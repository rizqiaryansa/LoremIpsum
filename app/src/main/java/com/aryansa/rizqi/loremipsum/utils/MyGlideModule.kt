package com.aryansa.rizqi.loremipsum.utils

import android.content.Context
import com.aryansa.rizqi.loremipsum.R
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class MyGlideModule: AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        val req = RequestOptions()
            .placeholder(R.drawable.img_placeholder_img)
            .error(R.drawable.img_placeholder_img)
            .format(DecodeFormat.PREFER_ARGB_8888)
        builder.setDefaultRequestOptions(req)
    }
}