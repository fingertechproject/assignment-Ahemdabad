package com.example.assignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.assignment.R
import com.example.assignment.UserFullDataActivity
import com.example.assignment.models.Data

class UserAdapter(val context:Context,val list:List<Data>):RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val singleItem = list.get(position)
        holder.firstName.text = singleItem.first_name
        holder.lastName.text = singleItem.last_name
        holder.email.text = singleItem.email
        Glide.with(context).load(singleItem.avatar).into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context,UserFullDataActivity::class.java)
            intent.putExtra("DATA",singleItem)
            context.startActivity(intent)
        }
    }


    override fun getItemCount() = list.size
}

class UserViewHolder(item:View):RecyclerView.ViewHolder(item){
    val firstName = item.findViewById<TextView>(R.id.firstName)
    val lastName = item.findViewById<TextView>(R.id.lastName)
    val email = item.findViewById<TextView>(R.id.userEmail)
    val image = item.findViewById<ImageView>(R.id.userDp)
}