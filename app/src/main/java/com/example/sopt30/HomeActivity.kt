package com.example.sopt30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt30.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionAction()
    }

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


}