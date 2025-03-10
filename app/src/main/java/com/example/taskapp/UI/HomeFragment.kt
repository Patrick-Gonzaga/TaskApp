package com.example.taskapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskapp.R
import com.example.taskapp.UI.adapter.ViewPagerAdapter
import com.example.taskapp.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
    }

    private fun initTabs(){
        val VPAdapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = VPAdapter

        VPAdapter.addFragment(TodoFragment(), R.string.status_task_todo)
        VPAdapter.addFragment(TodoFragment(), R.string.status_task_doing)
        VPAdapter.addFragment(TodoFragment(), R.string.status_task_done)

        binding.viewPager.offscreenPageLimit = VPAdapter.itemCount
        TabLayoutMediator(binding.tabs, binding.viewPager){tab, position ->
            tab.text = getString(VPAdapter.getTitle(position))
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}