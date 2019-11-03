package com.aryansa.rizqi.loremipsum.presentation.viewholders

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.R
import com.aryansa.rizqi.loremipsum.domain.model.remote.Data
import com.aryansa.rizqi.loremipsum.presentation.adapters.ImageAdapter

class MultipleViewHolder(view: View, val context: Context): RecyclerView.ViewHolder(view) {

    private var title: AppCompatTextView = view.findViewById(R.id.tvTitleMultipleLorem)
    private var content: AppCompatTextView = view.findViewById(R.id.tvContentMultipleLorem)
    private var listImage: RecyclerView = view.findViewById(R.id.rvMultipleLorem)

    fun bind(data: Data) {

        if(data.type == "multiple") {
            title.text = data.title
            content.text = data.content

            listImage.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = ImageAdapter(data.media, context)
            }
        }
    }
}