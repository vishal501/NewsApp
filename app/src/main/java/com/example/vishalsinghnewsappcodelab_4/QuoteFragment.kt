package com.example.vishalsinghnewsappcodelab_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vishalsinghnewsappcodelab_4.ItemClicked.Clicked
import com.example.vishalsinghnewsappcodelab_4.databinding.FragmentHomeBinding
import com.example.vishalsinghnewsappcodelab_4.databinding.FragmentQuoteBinding
import com.example.vishalsinghnewsappcodelab_4.databinding.QuoteimgLayoutBinding
import kotlinx.android.synthetic.main.fragment_quote.*
import kotlinx.android.synthetic.main.fragment_quote.view.*


class QuoteFragment(private val quote: Clicked) : Fragment() {
    private lateinit var binding: FragmentQuoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_quote, container, false)
//        return view
        binding= FragmentQuoteBinding.inflate(inflater,container,false)
        val root:View= binding.root

        binding.quoteMyFeed.setOnClickListener {
            quote.moveFirst()
        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.quote_btn.setOnClickListener{
            val frag = DiscoverFragment()
            val trans = activity?.supportFragmentManager?.beginTransaction()
            trans?.replace(R.id.quote_framelayout,frag)
            trans?.addToBackStack(null)?.commit()

        }

    }

}