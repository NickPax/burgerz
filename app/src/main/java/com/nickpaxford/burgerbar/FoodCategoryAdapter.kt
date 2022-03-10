package com.nickpaxford.burgerbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nickpaxford.burgerbar.fragments.FoodCategoriesFragmentDirections


class FoodCategoryAdapter(
    private val context: Context,
    private val foodCategories:FoodCategories
    ) : RecyclerView.Adapter<FoodCategoryAdapter.FoodCategoryViewHolder>() {

    private val categoryImageURL = "http://my-giddy-aunt.pl/food-order/images/category/"

    class FoodCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.my_imageview)
        val foodCategoryName: TextView = itemView.findViewById(R.id.my_text_view_1)


    }

    // method is called by the recycler view - it returns a FoodCategoryViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_categories_layout,
            parent, false)

        return FoodCategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodCategoryViewHolder, position: Int) {
        val currentItem = foodCategories[position]
        Glide.with(context).load(categoryImageURL + currentItem.image_name).into(holder.imageView)
        holder.foodCategoryName.text = currentItem.title
        var navController: NavController? = null
        holder.itemView.setOnClickListener{
            val categoryId = currentItem.id.toString()
            val action = FoodCategoriesFragmentDirections.actionFoodCategoriesFragmentToFoodsFragment(categoryId)

            navController = Navigation.findNavController(holder.itemView)
            navController!!.navigate(action)
        }

    }

    override fun getItemCount() = foodCategories.size
}