package com.example.recyclettuga1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclettuga1.ContactDomain
import com.example.recyclettuga1.R

class ContactAdapter(
    private val contactList: ArrayList<ContactDomain>
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val titleText: TextView = itemView.findViewById(R.id.titleText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_contact_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.titleText.text = contact.name

        val resourceId = holder.itemView.context.resources.getIdentifier(
            contact.picAddress, // contoh: "user_1"
            "drawable",
            holder.itemView.context.packageName
        )

        Glide.with(holder.itemView.context)
            .load(resourceId)
            .placeholder(R.drawable.user_1)
            .into(holder.pic)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
