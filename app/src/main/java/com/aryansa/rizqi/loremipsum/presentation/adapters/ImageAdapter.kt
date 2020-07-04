package com.aryansa.rizqi.loremipsum.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.common.utils.GlideApp
import com.aryansa.rizqi.loremipsum.databinding.ItemMultipleImageBinding

class ImageAdapter(private val listImage: List<String>, val context: Context) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = listImage[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val imageBinding = ItemMultipleImageBinding.inflate(inflater, parent, false)
        return ImageViewHolder(imageBinding)
    }

    inner class ImageViewHolder(private val binding: ItemMultipleImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: String) {
            with(binding) {
                GlideApp.with(context).load(image).into(ivMultipleImage)
            }
        }
    }
}