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
    private var _binding: FragmentRepositoryListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRepositoryAdapter()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}