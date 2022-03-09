package com.nickpaxford.burgerbar

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.GsonBuilder
import com.nickpaxford.burgerbar.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

//    private val url = "http://my-giddy-aunt.pl/food-order/np-index.php"
//    private lateinit var binding: ActivityMainBinding

//    var userInfoItem = arrayOf<UserInfoItem>()
//    private val userInfo = UserInfo()

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

//        swipe_layout.setOnRefreshListener {
//            downloadTask()
//        }
//
//        downloadTask()
    }
//
//    private fun downloadTask() {
//        swipe_layout.isRefreshing = true
//            val stringRequest=StringRequest(url, {
//            val gsonBuilder=GsonBuilder()
//            val gson = gsonBuilder.create()
//            userInfoItem = gson.fromJson(it,Array<UserInfoItem>::class.java)
//            userInfoItem.forEach {
//                userInfo.add(it)
//            }
//
//                showFood()
//
////            adapter.mySetOnItemClickListener(object : UserAdapter.myOnItemClickListener{
////                override fun myOnItemClick(myPosition: Int) {
////                    Toast.makeText(this@MainActivity, "clicked at $myPosition", Toast.LENGTH_SHORT).show()
////                }
////
////            })
//
//            //performance optimisation if we know that our recyclerview has fixed width and height:
//            recycler_view.setHasFixedSize(true)
//
//        }, {
//                swipe_layout.isRefreshing = false
//                Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
//        })
//        val volleyQueue=Volley.newRequestQueue(this)
//
//        if (userInfo != null){
//            userInfo.clear()
//        }
//        volleyQueue.add(stringRequest)
//    }
//
//    private fun showFood() {
//
//        recycler_view.layoutManager = GridLayoutManager(this, 2)
//        swipe_layout.isRefreshing = false
//        val adapter = UserAdapter(this,userInfo)
//        recycler_view.adapter = adapter
//
//    }


//    private fun downloadTaskOriginal() {
//        val queue = Volley.newRequestQueue(this)
//        val request = StringRequest(Request.Method.GET, url,
//            { response ->
//            //Log.e("Hello", response.toString()) //-- first thing we did, shows the JSON (not an array ??)
//            //JSON (response) is a JSON object to begin with (not an array)
//            val data = response.toString()
//            val jArray = JSONArray(data)
//            //Log.e("array", jArray.toString()) //-- next thing we did, now we see the array
//            for (i in 0 until jArray.length()){
//                val jObject = jArray.getJSONObject(i) // 'object'?
//              //  Log.e("jObject", jObject.toString(i))
//
//                val id = jObject.getInt("id")
//                val title = jObject.getString("title")
//                val imageName = jObject.getString("image_name")
//                val imageURL = categoryImageURL + imageName
//                val featured = jObject.getString("featured")
//                val active = jObject.getString("active")
//
//                Log.e("id", id.toString())
//                Log.e("title", title.toString())
//                Log.e("imageName", imageName.toString())
//                Log.e("imageURL", imageURL)
//                Log.e("featured", featured.toString())
//                Log.e("active", active.toString())
//            }
//        },
//            {  })
//        queue.add(request)
//    }

}

//    private val apiUrl="https://api.github.com/users"
//val exampleList = generateDummyList(500)

//private val url = "https://jsonplaceholder.typicode.com/posts"
//private val url = "https://kantorgetrr.000webhostapp.com/phpconnect.php"

//To get localhost to work, had to add -- android:usesCleartextTraffic="true" to manifest.
//And had to change IP to 10.0.2.2
//private val url = "http://10.0.2.2:8080/burger-bar/index.php"

//    private val categoryImageURL = "http://localhost:8080/food-order/images/category/"
//    private val url = "http://10.0.2.2:8080/food-order/np-index.php"