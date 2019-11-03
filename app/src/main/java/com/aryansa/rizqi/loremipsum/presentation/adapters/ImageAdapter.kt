package com.aryansa.rizqi.loremipsum.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.R
import com.aryansa.rizqi.loremipsum.utils.GlideApp

class ImageAdapter(private val listImage: List<String>, val context: Context)
    : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = listImage[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_multiple_image, parent, false))
    }

    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val imageLorem: AppCompatImageView = itemView.findViewById(R.id.ivMultipleImage)

        fun bind(image: String) {
            GlideApp.with(context).load(image).into(imageLorem)
        }
    }
}