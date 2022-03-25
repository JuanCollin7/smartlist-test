package com.jc.smartlisttest

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jc.smartlisttest.databinding.ActivityTagDetailBinding
import com.jc.smartlisttest.models.Tag

class TagDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTagDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTagDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLayout()
    }

    private fun setLayout() {
        val tag = intent.getParcelableExtra<Tag>(ARG_TAG) ?: return
        binding.tagDetailTagButton.text = tag.name
        binding.tagDetailTagButton.backgroundTintList = ColorStateList.valueOf(tag.color)
        binding.tagDetailQtyTextView.text = "1 Contact"
    }

    companion object {
        private const val ARG_TAG = "TAG"

        fun getInstance(context: Context, tag: Tag) = Intent(context, TagDetailActivity::class.java).apply {
            putExtra(ARG_TAG, tag)
        }
    }
}