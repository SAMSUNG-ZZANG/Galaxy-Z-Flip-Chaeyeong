package com.example.sopt30.presentation.view.profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FollowViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment){
        val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}