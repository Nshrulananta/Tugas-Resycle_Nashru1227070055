package com.example.latihan2resycle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.latihan2resycle.databinding.ActivityNameListBinding
import com.example.latihan2resycle.NameList

class NameAdapter : ListAdapter<String, NameList>(comparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): NameList {
        return NameList(
            ActivityNameListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: NameList, position: Int)
    {
        getItem(position).let {
            holder.binding.nameInfo.text = getItem(position)
        }
    }
    companion object {
        val comparator = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem:
            String): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}