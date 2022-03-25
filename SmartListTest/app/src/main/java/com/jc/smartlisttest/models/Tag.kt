package com.jc.smartlisttest.models

import android.graphics.Color
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tag(val name: String, val color: Int): Parcelable