package com.jc.smartlisttest.ui.tags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jc.smartlisttest.TagDetailActivity
import com.jc.smartlisttest.databinding.FragmentTagsBinding
import com.jc.smartlisttest.models.Tag
import com.jc.smartlisttest.ui.home.TagItemClickListener

class TagsFragment : Fragment(), TagItemClickListener {

    private var _binding: FragmentTagsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val tagsViewModel =
                ViewModelProvider(this).get(TagsViewModel::class.java)

        _binding = FragmentTagsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = TagListAdapter(this)
        binding.tagList.adapter = adapter

        tagsViewModel.tags.observe(viewLifecycleOwner, Observer {
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

    override fun onItemClicked(item: Tag) {
        startActivity(TagDetailActivity.getInstance(requireContext(), item))
    }
}