package com.nickpaxford.burgerbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nickpaxford.burgerbar.fragments.DetailFragment
import com.nickpaxford.burgerbar.fragments.FoodCategoriesFragment
import com.nickpaxford.burgerbar.fragments.FoodCategoriesFragmentDirections


class UserAdapter(private val context: Context, private val userInfo:UserInfo) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

   // val categoryImageURL = "http://10.0.2.2:8080/food-order/images/category/"

//   private lateinit var myListener: myOnItemClickListener

//    interface myOnItemClickListener{
//        fun myOnItemClick(myPosition: Int)
//    }

//    fun mySetOnItemClickListener(listener: myOnItemClickListener){
//        myListener = listener
//    }


    private val categoryImageURL = "http://my-giddy-aunt.pl/food-order/images/category/"

    class UserViewHolder(itemView: View /*, listener: myOnItemClickListener */) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.my_imageview)
        val userName: TextView = itemView.findViewById(R.id.my_text_view_1)

//        init{
//            itemView.setOnClickListener {
//                 listener.myOnItemClick(adapterPosition)
//            }
//
//        }

    }

    // method is called by the recycler view - it returns an UserViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_layout,
            parent, false)

        return UserViewHolder(itemView /*, myListener */)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = userInfo[position]
        Glide.with(context).load(categoryImageURL + currentItem.image_name).into(holder.imageView)
        holder.userName.text = currentItem.title
        var navController: NavController? = null
        holder.itemView.setOnClickListener{
            val action = FoodCategoriesFragmentDirections.actionFoodCategoriesFragmentToMyDetailFragment2()

            navController = Navigation.findNavController(holder.itemView)
            navController!!.navigate(action)
        }

//        (object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                val activity = v!!.context as AppCompatActivity
//                var detailFragment = DetailFragment()
//                activity.supportFragmentManager.beginTransaction().replace(R.id.main_recyclerview, detailFragment)
//                    .addToBackStack(null)
//                  /*  .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) */
//                    .commit()
//            }
//        }
//                )
    }

    override fun getItemCount() = userInfo.size
}