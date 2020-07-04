package com.aryansa.rizqi.loremipsum.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryansa.rizqi.loremipsum.databinding.ItemMultipleLoremBinding
import com.aryansa.rizqi.loremipsum.databinding.ItemSingleLoremBinding
import com.aryansa.rizqi.loremipsum.domain.model.remote.LoremIpSumResponse
import com.aryansa.rizqi.loremipsum.presentation.viewholders.MultipleViewHolder
import com.aryansa.rizqi.loremipsum.presentation.viewholders.SingleViewHolder

class LoremAdapter(val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val single = 0
    private val multiple = 1

    private var listLorem: List<LoremIpSumResponse.Data> = listOf()

    fun setLoremListData(loremList: List<LoremIpSumResponse.Data>) {
        this.listLorem = loremList
        notifyDataSetChanged()
    }

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
                val viewSingle = ItemSingleLoremBinding.inflate(inflater, parent, false)
                viewHolder = SingleViewHolder(viewSingle, context)
            }

            multiple -> {
                val viewMultiple = ItemMultipleLoremBinding.inflate(inflater, parent, false)
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