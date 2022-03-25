package com.jc.smartlisttest.ui.home

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jc.smartlisttest.ContactItemViewHolder
import com.jc.smartlisttest.R
import com.jc.smartlisttest.models.Contact

class ContactListAdapter(private val itemInterface: ContactItemClickListener): RecyclerView.Adapter<ContactItemViewHolder>()  {

    var data = listOf<Contact>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        val item = data[position]
        holder.nameTextView.text = item.name
        holder.phoneTextView.text = item.phone
        holder.tagButton.text = item.tag.name
        holder.tagButton.backgroundTintList = ColorStateList.valueOf(item.tag.color)

        holder.itemView.setOnClickListener {
            itemInterface.onItemClicked(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.contact_item_view, parent, false) as CardView

        return ContactItemViewHolder(view)
    }
}