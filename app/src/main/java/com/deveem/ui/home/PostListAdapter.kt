package com.deveem.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deveem.data.models.Post
import com.deveem.databinding.ItemPostBinding

class PostListAdapter(private val items: List<Post>, private val clickListener: OnItemClickListener): RecyclerView.Adapter<PostListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.binding.root.setOnClickListener {
            clickListener.onItemClick(items[position], position)
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.tvTitle.text = item.title
            binding.tvBody.text = item.body
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Post, position: Int)
    }
}