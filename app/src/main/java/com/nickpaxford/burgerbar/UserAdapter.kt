package com.nickpaxford.burgerbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.example_item.view.*

class UserAdapter(private val context: Context, val userInfo:UserInfo ) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    //val categoryImageURL = "http://10.0.2.2:8080/food-order/images/category/"

    private lateinit var myListener: myOnItemClickListener

    interface myOnItemClickListener{
        fun myOnItemClick(myPosition: Int)
    }

    fun mySetOnItemClickListener(listener: myOnItemClickListener){
        myListener = listener
    }


    private val categoryImageURL = "http://my-giddy-aunt.pl/food-order/images/category/"

    class UserViewHolder(itemView: View, listener: myOnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.my_imageview)
        val userName: TextView = itemView.findViewById(R.id.my_text_view_1)

        init{
            itemView.setOnClickListener {
                 listener.myOnItemClick(adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_layout,
            parent, false)

        return UserViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userInfo[position]
        Glide.with(context).load(categoryImageURL + currentItem.image_name).into(holder.imageView)
        holder.userName.text = currentItem.title
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
              //  val demoFragment= DemoFragment()
            }
        })
    }

    override fun getItemCount() = userInfo.size
}