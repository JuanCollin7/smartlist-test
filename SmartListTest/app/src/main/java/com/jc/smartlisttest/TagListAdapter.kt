package com.jc.smartlisttest

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.smartlisttest.models.Tag

class TagListAdapter: RecyclerView.Adapter<TagItemViewHolder>()  {

    var data = listOf<Tag>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TagItemViewHolder, position: Int) {
        val item = data[position]
        holder.tagButton.text = item.name
        holder.tagButton.backgroundTintList = ColorStateList.valueOf(item.color)
        holder.qtyTextView.text = "1 contact"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.tag_item_view, parent, false) as CardView

        return TagItemViewHolder(view)
    }
}