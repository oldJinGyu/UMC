package com.example.mission6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mission6.databinding.Fragment1Binding
import com.example.mission6.databinding.Fragment2Binding
import com.example.mission6.databinding.Fragment3Binding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ThirdFragment : Fragment() {
    private lateinit var viewBinding: Fragment3Binding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = Fragment3Binding.inflate(layoutInflater)
        viewPager = viewBinding.viewPager
        tabLayout = viewBinding.tabLayout

        // ViewAdapter 생성
        val adapter = ViewAdapter(childFragmentManager, lifecycle)

        // Fragment 추가
        adapter.addFragment(UFragment(), "U")
        adapter.addFragment(MFragment(), "M")
        adapter.addFragment(CFragment(), "C")

        // ViewPager와 TabLayout 연결
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

        return viewBinding.root
    }
}

