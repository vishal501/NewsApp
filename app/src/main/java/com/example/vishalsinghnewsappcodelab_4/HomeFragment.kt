package com.example.vishalsinghnewsappcodelab_4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.vishalsinghnewsappcodelab_4.Adapter.MyAdapter
import com.example.vishalsinghnewsappcodelab_4.ItemClicked.Clicked
import com.example.vishalsinghnewsappcodelab_4.ItemClicked.ItemClicked
import com.example.vishalsinghnewsappcodelab_4.MyDataClass.Article
import com.example.vishalsinghnewsappcodelab_4.MyDataClass.MyDataItem
import com.example.vishalsinghnewsappcodelab_4.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment(private val ki: Clicked) : Fragment(), ItemClicked {

    companion object{
        var setBar:Boolean = false
    }
    private var alist:List<Article>? = null

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentHomeBinding.inflate(inflater,container,false)
        apiCall()

        binding.homeDiscover.setOnClickListener {
            ki.moveNext()
        }
        binding.homeRefresh.setOnClickListener {
            apiCall()
        }

        binding.homeTop.setOnClickListener {
            view_pager.setCurrentItem(0,true)
            onRefresh()
        }

        return binding.root
    }

    private fun apiCall() {
        CoroutineScope(Dispatchers.IO).launch {
            val dataObj = ApiInterface.Retrofitobject.getInstance().create(ApiInterface::class.java)
            val result = dataObj.getData()

            result.enqueue(object : Callback<MyDataItem> {
                override fun onResponse(call: Call<MyDataItem>, response: Response<MyDataItem>) {

                    val api = response.body()

                    if (api != null) {

                        setData(api.articles)
                    }
                }

                override fun onFailure(call: Call<MyDataItem>, t: Throwable) {
                    Log.d("msg","Api Not Hit")
                }

            })


        }
    }
    private fun setData(art: List<Article>) {
        alist=art

        val myAdapter=alist?.let { MyAdapter(it as ArrayList<Article>,this) }
        PagerSnapHelper().attachToRecyclerView(binding.rvHomeRecyclerView)
        binding.viewPager.setPageTransformer(SingleCardPage())
        binding.viewPager.adapter=myAdapter

    }

 fun Appbar(){
    when(setBar)
    {
        true ->
        {
            binding.appbar.visibility= View.VISIBLE
            binding.appbar.visibility= View.GONE
            setBar=false
        }
        false ->
        {
            binding.appbar.visibility= View.VISIBLE
            binding.appbar.visibility= View.VISIBLE
            setBar=true
        }
    }
}
    fun onTop()
    {

        binding.homeRefresh.visibility= View.GONE
        binding.homeTop.visibility= View.VISIBLE
    }

    fun onRefresh()
    {

        binding.homeRefresh.visibility= View.VISIBLE
        binding.homeTop.visibility= View.GONE
    }
    fun onHideBar()
    {
        binding.appbar.visibility= View.GONE
    }



    override fun itemClicked(position: Int) {
        if(position == 0){
            onRefresh()
        }
        else{
            onHideBar()
            onTop()
            setBar=false
        }
    }


}



