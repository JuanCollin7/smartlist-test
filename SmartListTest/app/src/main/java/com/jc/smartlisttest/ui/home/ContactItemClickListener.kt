package com.jc.smartlisttest.ui.home
import com.jc.smartlisttest.models.Contact

interface ContactItemClickListener {
    fun onItemClicked(item: Contact)
}