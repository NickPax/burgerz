package com.nickpaxford.burgerbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

//we add the type argument <> to Adapter after making the internal class
//through this type argument the adapter knows that this is the ViewHolder it's supposed to use
class ExampleAdapter(private val exampleList: List<ExampleItem> ) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    //when we later create an object of it so it can look for the image view and text view inside it.
    //for this we add a constructor by adding the parentheses
    //we also pass it to the super class of the constructor because it needs it internally.

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 3 properties that store the references to the three views in our row layout
        //this is how the view holder caches these references
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2


    }
    // method is called by the recycler view - it returns an ExampleViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
        parent, false)

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

    }

    override fun getItemCount() = exampleList.size
}