package com.aryansa.rizqi.loremipsum.presentation.adapters

import androidx.databinding.BindingAdapter
import com.aryansa.rizqi.loremipsum.utils.extensions.gone
import com.aryansa.rizqi.loremipsum.utils.extensions.visible
import com.facebook.shimmer.ShimmerFrameLayout

@BindingAdapter("setShimmer")
fun ShimmerFrameLayout.setShimmer(boolean: Boolean) {
    if(boolean) {
        startShimmer()
        visible()
    } else {
        stopShimmer()
        gone()
    }
}