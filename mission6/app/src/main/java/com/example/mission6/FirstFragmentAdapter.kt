package com.example.mission6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FirstFragmentAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ImageFragment1() // 첫 번째 페이지에 표시할 Fragment
            1 -> ImageFragment2() // 두 번째 페이지에 표시할 Fragment
            2 -> ImageFragment3() // 세 번째 페이지에 표시할 Fragment
            else -> Fragment() // 기본값으로 빈 Fragment 반환
        }
    }
}