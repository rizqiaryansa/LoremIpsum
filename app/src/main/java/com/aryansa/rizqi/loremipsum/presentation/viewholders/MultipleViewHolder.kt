package com.aryansa.rizqi.loremipsum.presentation.viewholders

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.databinding.ItemMultipleLoremBinding
import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse
import com.aryansa.rizqi.loremipsum.presentation.adapters.ImageAdapter

class MultipleViewHolder(
    private val binding: ItemMultipleLoremBinding,
    val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: LoremIpSumResponse.Data) {
        with(binding) {
            if (data.type == "multiple") {
                tvTitleMultipleLorem.text = data.title
                tvContentMultipleLorem.text = data.content

                rvMultipleLorem.apply {
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = data.media?.let { ImageAdapter(it, context) }
                }
            }
        }
    }
}