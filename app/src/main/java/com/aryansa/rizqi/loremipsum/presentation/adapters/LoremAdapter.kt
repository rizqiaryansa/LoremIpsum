package com.aryansa.rizqi.loremipsum.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.R
import com.aryansa.rizqi.loremipsum.domain.model.remote.Data
import com.aryansa.rizqi.loremipsum.presentation.viewholders.MultipleViewHolder
import com.aryansa.rizqi.loremipsum.presentation.viewholders.SingleViewHolder

class LoremAdapter(list: List<Data>, val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val single = 0
    private val multiple = 1

    private var listLorem: List<Data> = list

    override fun getItemCount(): Int = listLorem.size

    override fun getItemViewType(position: Int): Int {
        if(listLorem[position].type == "image") {
            return single
        } else if(listLorem[position].type == "multiple") {
            return multiple
        }
        return -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var viewHolder: RecyclerView.ViewHolder

        val inflater = LayoutInflater.from(parent.context)

        when(viewType) {
            single -> {
                val viewSingle = inflater.inflate(R.layout.item_single_lorem, parent, false)
                viewHolder = SingleViewHolder(viewSingle, context)
            }

            multiple -> {
                val viewMultiple = inflater.inflate(R.layout.item_multiple_lorem, parent, false)
                viewHolder = MultipleViewHolder(viewMultiple, context)
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = listLorem[position]

        when(holder.itemViewType) {
            single -> {
                val vhSingle = holder as SingleViewHolder
                vhSingle.bind(data)
            }
            multiple -> {
                val vhMultiple = holder as MultipleViewHolder
                vhMultiple.bind(data)
            }
        }
    }
}