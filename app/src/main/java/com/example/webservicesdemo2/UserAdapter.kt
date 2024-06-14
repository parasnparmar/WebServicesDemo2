package com.example.webservicesdemo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webservicesdemo2.databinding.UserViewBinding
import com.squareup.picasso.Picasso

class UserAdapter(private var users: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userViewBinding: UserViewBinding
        init {
            userViewBinding = UserViewBinding.bind(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

            return UserViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.user_view,null)))
        }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userViewBinding.user = users[position]
//        Glide.with(holder.itemView)
//            .load(users[position].avatar)
//            .centerCrop()
//            .placeholder(R.drawable.ic_launcher_foreground)
//            .error(R.mipmap.ic_launcher_round)
//            .into(holder.userViewBinding.imgAvatar)

        Picasso.get()
            .load(users[position].avatar)
            .resize(50, 50)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.mipmap.ic_launcher)
            .into(holder.userViewBinding.imgAvatar)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}