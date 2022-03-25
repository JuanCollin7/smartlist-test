package com.jc.smartlisttest.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jc.smartlisttest.ContactItemViewHolder
import com.jc.smartlisttest.ContactListAdapter
import com.jc.smartlisttest.MainActivity
import com.jc.smartlisttest.databinding.FragmentHomeBinding
import com.jc.smartlisttest.models.Contact
import com.jc.smartlisttest.ui.tags.TagsFragment

class HomeFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = ContactListAdapter(this)
        binding.contactList.adapter = adapter

        homeViewModel.contacts.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: Contact) {
        Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this@HomeFragment.context, MainActivity::class.java)
        startActivity(intent)
    }
}

interface OnItemClickListener {
    fun onItemClicked(item: Contact)
}