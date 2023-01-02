package com.example.vishalsinghnewsappcodelab_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.vishalsinghnewsappcodelab_4.Adapter.QuoteAdapter
import com.example.vishalsinghnewsappcodelab_4.ItemClicked.ItemClicked
import com.example.vishalsinghnewsappcodelab_4.databinding.FragmentDiscoverBinding


class DiscoverFragment : Fragment(), ItemClicked {

    private lateinit var binding: FragmentDiscoverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDiscoverBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = QuoteAdapter(requireActivity())
        PagerSnapHelper().attachToRecyclerView(binding.discoverRecycler)
        binding.discoverViewPager.setPageTransformer(SingleCardPage())
//        discover_recycler.layoutManager=LinearLayoutManager(activity)

        binding.discoverViewPager.adapter=adapter
    }

    override fun itemClicked(position: Int) {
        TODO("Not yet implemented")
//        Toast.makeText(activity, "Item clicked at $position", Toast.LENGTH_SHORT).show()

    }
}