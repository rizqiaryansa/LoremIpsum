package com.aryansa.rizqi.loremipsum.presentation.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.databinding.ItemSingleLoremBinding
import com.aryansa.rizqi.loremipsum.domain.model.remote.Data
import com.aryansa.rizqi.loremipsum.utils.GlideApp

class SingleViewHolder(private val binding: ItemSingleLoremBinding,
                       val context: Context): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Data) {
        with(binding) {
            if (data.type == "image") {
                tvTitleSingleLorem.text = data.title
                tvContentSingleLorem.text = data.content
                GlideApp.with(context).load(data.media[0]).into(ivSingleLorem)
            }
        }
    }
}