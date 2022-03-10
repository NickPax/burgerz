package com.nickpaxford.burgerbar.fragments

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.nickpaxford.burgerbar.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_categories_fragment.*

class FoodsFragment : Fragment() {
    private val args: FoodsFragmentArgs by navArgs()

    companion object {
        fun newInstance() = FoodsFragment()
    }

    var foodItem = arrayOf<FoodItem>()
    private val foods = Foods()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.foods_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
      // viewModel = ViewModelProvider(this).get(FoodCategoriesViewModel::class.java)
        // TODO: Use the ViewModel

        swipe_layout.setOnRefreshListener {
            downloadTask()
        }

            downloadTask()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


    private fun downloadTask() {
        var categoryId: String = args.categoryId
        val url = "http://my-giddy-aunt.pl/food-order/np-burgers.php?category_id=$categoryId"
        swipe_layout.isRefreshing = true
        val stringRequest= StringRequest(url, {
            val gsonBuilder= GsonBuilder()
            val gson = gsonBuilder.create()
            foodItem = gson.fromJson(it,Array<FoodItem>::class.java)
            foodItem.forEach {
                foods.add(it)
            }

            showFood()

            recycler_view.setHasFixedSize(true)

        }, {
            swipe_layout.isRefreshing = false
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        })
        val volleyQueue= Volley.newRequestQueue(activity)

        if (foods != null){
            foods.clear()
        }
        volleyQueue.add(stringRequest)
    }

    private fun showFood() {

        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.getContext()
        swipe_layout.isRefreshing = false
        val adapter = FoodsAdapter(recycler_view.getContext(),foods)
        recycler_view.adapter = adapter

    }


}