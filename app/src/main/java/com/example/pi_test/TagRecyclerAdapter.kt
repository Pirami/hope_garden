package com.example.pi_test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pi_test.databinding.TagItemBinding
import com.example.pi_test.models.Search

class TagRecyclerAdapter(private val itemList: List<Search>): RecyclerView.Adapter<TagRecyclerAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding: TagItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) {
            binding.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = TagItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}