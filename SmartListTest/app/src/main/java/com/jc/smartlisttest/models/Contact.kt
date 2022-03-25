package com.jc.smartlisttest.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(val name: String, val phone: String, val tag: Tag): Parcelable