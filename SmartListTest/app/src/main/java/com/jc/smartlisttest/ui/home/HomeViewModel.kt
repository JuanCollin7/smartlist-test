package com.jc.smartlisttest.ui.home

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jc.smartlisttest.R
import com.jc.smartlisttest.models.Contact
import com.jc.smartlisttest.models.Tag

class HomeViewModel : ViewModel() {

    private var _contacts = MutableLiveData<ArrayList<Contact>>()
    val contacts: LiveData<ArrayList<Contact>> = _contacts

    init {
        val contact1 = Contact("Juan", "+55 51 91234-5678", Tag("SCHEDULED"))
        val contact2 = Contact("Lucas", "+55 51 99876-5432", Tag("TO CONTACT"))
        _contacts.value = arrayListOf(contact1, contact2)
    }
}