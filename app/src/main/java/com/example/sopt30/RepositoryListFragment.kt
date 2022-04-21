package com.example.sopt30

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sopt30.databinding.FragmentRepositoryListBinding

class RepositoryListFragment : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private lateinit var binding: FragmentRepositoryListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepositoryListBinding.inflate(layoutInflater, container, false)
        initRepositoryAdapter()
        return binding.root
    }

    private fun initRepositoryAdapter() {
        repositoryAdapter = RepositoryAdapter()
        binding.rvRepositoryList.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData("레포1", "설명ㅎㅎㅎ"),
                RepositoryData("레포2", "설명ㅎㅎㅎ"),
                RepositoryData("레포3", "설명ㅎㅎㅎ"),
                RepositoryData("레포4", "설명ㅎㅎㅎ"),
                RepositoryData("레포5", "설명ㅎㅎㅎ"),
                RepositoryData("레포6", "설명ㅎㅎㅎ"),
                RepositoryData("레포7", "설명ㅎㅎㅎ")
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }
}