package com.jc.smartlisttest

/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//import java.util.concurrent.TimeUnit
//import java.util.*

class ContactItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
    val tagButton: Button = itemView.findViewById(R.id.tagButton)
}

class TagItemViewHolder(private val itemView: CardView): RecyclerView.ViewHolder(itemView) {
    val tagButton: Button = itemView.findViewById(R.id.tagButton)
    val qtyTextView: TextView = itemView.findViewById(R.id.qtyTextView)
}