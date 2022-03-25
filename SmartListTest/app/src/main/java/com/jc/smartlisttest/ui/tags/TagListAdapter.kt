package com.jc.smartlisttest.ui.tags

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.smartlisttest.R
import com.jc.smartlisttest.TagItemViewHolder
import com.jc.smartlisttest.models.Tag
import com.jc.smartlisttest.ui.home.ContactItemClickListener
import com.jc.smartlisttest.ui.home.TagItemClickListener

class TagListAdapter(private val itemInterface: TagItemClickListener): RecyclerView.Adapter<TagItemViewHolder>()  {

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

        holder.itemView.setOnClickListener {
            itemInterface.onItemClicked(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.tag_item_view, parent, false) as CardView

        return TagItemViewHolder(view)
    }
}