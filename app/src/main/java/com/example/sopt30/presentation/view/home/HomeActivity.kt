package com.example.sopt30.presentation.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.sopt30.*
import com.example.sopt30.databinding.ActivityHomeBinding
import com.example.sopt30.presentation.view.camera.CameraFragment
import com.example.sopt30.presentation.view.profile.ProfileFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private lateinit var homeViewpagerAdapter: HomeViewPagerAdapter
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initTransactionAction()
        initAdapter()
        initBottomNavi()
    }

    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())
        homeViewpagerAdapter = HomeViewPagerAdapter(this)
        homeViewpagerAdapter.fragments.addAll(fragmentList)

        binding.vpHome.adapter = homeViewpagerAdapter
    }

    private fun initBottomNavi() {
        binding.vpHome.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.bnHome.menu.getItem(position).isChecked = true
            }
        })

        binding.bnHome.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_profile -> {
                    binding.vpHome.currentItem = FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vpHome.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpHome.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }

    /*
    private fun initTransactionAction() {
        val followerFragment = FollowerListFragment()
        val repositoryFragment = RepositoryListFragment()

        supportFragmentManager.beginTransaction().add(R.id.fcv_list, followerFragment).commit()

        val transaction = supportFragmentManager.beginTransaction()

        binding.btnFollower.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fcv_list, followerFragment).commit()
        }

        binding.btnRepository.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fcv_list, repositoryFragment).commit()
        }
    }
*/

}