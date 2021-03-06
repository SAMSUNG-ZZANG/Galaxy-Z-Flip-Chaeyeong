package com.example.sopt30.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sopt30.presentation.view.profile.FollowViewPagerAdapter
import com.example.sopt30.presentation.view.profile.FollowerTabFragment
import com.example.sopt30.presentation.view.profile.FollowingTabFragment
import com.example.sopt30.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("Binding 초기화 안됨")
    private lateinit var followViewPagerAdapter: FollowViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initTabLayout()
    }

    private fun initAdapter() {
        val fragmentList = listOf(FollowingTabFragment(), FollowerTabFragment())

        followViewPagerAdapter = FollowViewPagerAdapter(this)
        followViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpTab.adapter = followViewPagerAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlList, binding.vpTab) {tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }
}