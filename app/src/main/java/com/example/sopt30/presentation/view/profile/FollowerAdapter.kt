package com.example.sopt30.presentation.view.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt30.data.FollwerData
import com.example.sopt30.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewholder>() {
    val followerList = mutableListOf<FollwerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewholder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewholder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewholder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size

    class FollowerViewholder(
        private val binding: ItemFollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : FollwerData) {
            binding.follwerData = data
        }
    }
}