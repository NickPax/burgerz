package com.nickpaxford.burgerbar.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.nickpaxford.burgerbar.R
import com.nickpaxford.burgerbar.UserAdapter
import com.nickpaxford.burgerbar.UserInfo
import com.nickpaxford.burgerbar.UserInfoItem
import com.nickpaxford.burgerbar.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_categories_fragment.*

class FoodCategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = FoodCategoriesFragment()
    }

    private lateinit var viewModel: FoodCategoriesViewModel

    var userInfoItem = arrayOf<UserInfoItem>()
    private val userInfo = UserInfo()
    private val url = "http://my-giddy-aunt.pl/food-order/np-index.php"
    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.food_categories_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FoodCategoriesViewModel::class.java)
        // TODO: Use the ViewModel

        swipe_layout.setOnRefreshListener {
            downloadTask()
        }

        downloadTask()
    }


    private fun downloadTask() {
        swipe_layout.isRefreshing = true
        val stringRequest= StringRequest(url, {
            val gsonBuilder= GsonBuilder()
            val gson = gsonBuilder.create()
            userInfoItem = gson.fromJson(it,Array<UserInfoItem>::class.java)
            userInfoItem.forEach {
                userInfo.add(it)
            }

            showFood()

            recycler_view.setHasFixedSize(true)

        }, {
            swipe_layout.isRefreshing = false
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        })
        val volleyQueue= Volley.newRequestQueue(activity)

        if (userInfo != null){
            userInfo.clear()
        }
        volleyQueue.add(stringRequest)
    }

    private fun showFood() {

        recycler_view.layoutManager = GridLayoutManager(activity, 2)
        recycler_view.getContext()
        swipe_layout.isRefreshing = false
        val adapter = UserAdapter(recycler_view.getContext(),userInfo)
        recycler_view.adapter = adapter

    }


}