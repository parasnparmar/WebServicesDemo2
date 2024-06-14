 package com.example.webservicesdemo2

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.webservicesdemo2.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
     private lateinit var activityMainBinding : ActivityMainBinding
     private lateinit var usersAdapter: UserAdapter
     private var users = ArrayList<User>()

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
         setContentView(activityMainBinding.root)

         initAdapter()
         WebThread(UserHandler()).execute()
     }

     private fun initAdapter(){
         usersAdapter = UserAdapter(users)
         activityMainBinding.recyclerViewUsers.adapter = usersAdapter
         activityMainBinding.recyclerViewUsers.layoutManager =
             LinearLayoutManager(this,
                 LinearLayoutManager.VERTICAL,false)
     }

     private inner class UserHandler : Handler(){
         override fun handleMessage(msg: Message) {
             super.handleMessage(msg)
             if(msg.obj == null){
                 makeToast("msg obj -- ${msg.obj}")
                 return
             }

             val users = msg.obj as ArrayList<User>
             this@MainActivity.users.addAll(users)
             usersAdapter.notifyDataSetChanged()         //imp

             for (user in users){
                 Log.e("tag","$user")
             }
         }
     }

     private fun makeToast(text : String){
         Toast.makeText(this,text,Toast.LENGTH_LONG).show()
     }
 }