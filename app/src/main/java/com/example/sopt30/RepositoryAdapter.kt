package com.example.sopt30

import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt30.databinding.ItemRepositoryListBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewholder>() {
    val repositoryList = mutableListOf<RepositoryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewholder {
        val binding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewholder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewholder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    override fun getItemCount(): Int {
        return repositoryList.size
    }

    class RepositoryViewholder(
        private val binding: ItemRepositoryListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RepositoryData) {
            binding.tvFollowerName.text = data.name
            binding.tvFollowerIntro.text = data.introduction
        }
    }
}