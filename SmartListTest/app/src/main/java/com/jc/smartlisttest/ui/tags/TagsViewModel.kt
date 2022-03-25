package com.jc.smartlisttest.ui.tags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jc.smartlisttest.models.Contact
import com.jc.smartlisttest.models.Tag

class TagsViewModel : ViewModel() {

    private var _tags = MutableLiveData<ArrayList<Tag>>()
    val tags: LiveData<ArrayList<Tag>> = _tags

    init {
        _tags.value = arrayListOf(Tag("SCHEDULE"), Tag("TO CONTACT"))
    }
}