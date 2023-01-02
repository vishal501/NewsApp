package com.example.vishalsinghnewsappcodelab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.vishalsinghnewsappcodelab_4.Adapter.ViewPagerAdapter
import com.example.vishalsinghnewsappcodelab_4.ItemClicked.Clicked
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import okhttp3.internal.wait

class MainActivity : AppCompatActivity() , Clicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val fragment: ArrayList<Fragment> = arrayListOf(
            HomeFragment(this),
            QuoteFragment(this)

        )

        val adapter = ViewPagerAdapter(fragment,this)
        viewPager.adapter=adapter



    }

    override fun moveNext() {
        viewPager.currentItem = 1
    }



    override fun moveFirst() {
        viewPager.currentItem = 0
    }
//    override fun onBackPressed() {
//        super.onBackPressed()
//        if(viewPager.getCurrentItem() == 1)
//        {
//            viewPager.setCurrentItem(0,true)
//        }
//        else{
//            finish()
//        }
//    }

}