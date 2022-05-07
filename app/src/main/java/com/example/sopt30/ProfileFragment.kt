package com.example.sopt30

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.sopt30.databinding.FragmentFollowerListBinding
import com.example.sopt30.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTransactionAction()
        initImage()
    }

    private fun initImage() {
        Glide.with(this)
            .load("https://s3.orbi.kr/data/file/united/957fd87b5938e6af46779e971012aa6d.jpg")
            .circleCrop()
            .into(binding.ivProfile)
    }

    private fun initTransactionAction() {
        val followerFragment = FollowerListFragment()
        val repositoryFragment = RepositoryListFragment()

        childFragmentManager.beginTransaction().add(R.id.fcv_list, followerFragment).commit()
        binding.btnFollower.isSelected = true

        val transaction = childFragmentManager.beginTransaction()

        binding.btnFollower.setOnClickListener {
            binding.btnFollower?.isSelected = binding.btnFollower?.isSelected != true
            binding.btnRepository.isSelected = false
            childFragmentManager.beginTransaction().replace(R.id.fcv_list, followerFragment).commit()
        }

        binding.btnRepository.setOnClickListener {
            binding.btnRepository?.isSelected = binding.btnRepository?.isSelected != true
            binding.btnFollower.isSelected = false
            childFragmentManager.beginTransaction().replace(R.id.fcv_list, repositoryFragment).commit()
        }
    }
}