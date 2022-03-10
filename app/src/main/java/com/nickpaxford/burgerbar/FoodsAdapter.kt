package com.nickpaxford.burgerbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodsAdapter (
    private val context: Context,
    private val foods:Foods

    ) : RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder>() {

    private val foodImageUrl = "http://my-giddy-aunt.pl/food-order/images/food/"


    class FoodsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.my_imageview)
        val foodName: TextView = itemView.findViewById(R.id.my_text_view_1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.foods_layout,
            parent, false)

        return FoodsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodsViewHolder, position: Int) {
        val currentItem = foods[position]
        Glide.with(context).load(foodImageUrl + currentItem.image_name).into(holder.imageView)
        holder.foodName.text = currentItem.title
    }


    override fun getItemCount() = foods.size
}