package com.aryansa.rizqi.loremipsum.presentation.viewholders

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.R
import com.aryansa.rizqi.loremipsum.domain.model.remote.Data
import com.aryansa.rizqi.loremipsum.utils.GlideApp

class SingleViewHolder(view: View, val context: Context): RecyclerView.ViewHolder(view) {

    private var title: AppCompatTextView = view.findViewById(R.id.tvTitleSingleLorem)
    private var content: AppCompatTextView = view.findViewById(R.id.tvContentSingleLorem)
    private var image: AppCompatImageView = view.findViewById(R.id.ivSingleLorem)

    fun bind(data: Data) {

        if(data.type == "image") {
            title.text = data.title
            content.text = data.content
            GlideApp.with(context).load(data.media[0]).into(image)
        }
    }
}