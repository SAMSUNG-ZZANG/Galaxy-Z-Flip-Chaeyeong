package com.example.sopt30

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sopt30.databinding.FragmentFollowerListBinding

class FollowerListFragment : Fragment() {
    private lateinit var followerAdapter : FollowerAdapter
    private lateinit var binding : FragmentFollowerListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowerListBinding.inflate(layoutInflater, container, false)
        initFollowerAdapter()

        return binding.root
    }

    private fun initFollowerAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollowerList.adapter = followerAdapter

        followerAdapter.followerList.addAll(
            listOf(
                FollwerData("이름1", "설명ㅇㅇㅇ"),
                FollwerData("이름2", "설명ㅇㅇㅇ"),
                FollwerData("이름3", "설명ㅇㅇㅇ"),
                FollwerData("이름4", "설명ㅇㅇㅇ"),
                FollwerData("이름5", "설명ㅇㅇㅇ"),
                FollwerData("이름6", "설명ㅇㅇㅇ"),
                FollwerData("이름7", "설명ㅇㅇㅇ"),
            )
        )
        followerAdapter.notifyDataSetChanged()
    }
}