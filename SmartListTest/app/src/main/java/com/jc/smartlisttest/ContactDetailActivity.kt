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
import com.jc.smartlisttest.databinding.ActivityContactDetailBinding
import com.jc.smartlisttest.models.Contact

class ContactDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLayout()
    }

    private fun setLayout() {
        val contact = intent.getParcelableExtra<Contact>(ARG_CONTACT) ?: return
        binding.contactDetailNameTextView.text = contact.name
        binding.contactDetailPhoneTextView.text = contact.phone
        binding.contactDetailTagButton.text = contact.tag.name
        binding.contactDetailTagButton.backgroundTintList = ColorStateList.valueOf(contact.tag.color)
    }

    companion object {
        private const val ARG_CONTACT = "CONTACT"

        fun getInstance(context: Context, contact: Contact) = Intent(context, ContactDetailActivity::class.java).apply {
            putExtra(ARG_CONTACT, contact)
        }
    }
}