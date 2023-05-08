package com.example.mission6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mission6.databinding.Fragment1Binding
import me.relex.circleindicator.CircleIndicator3

class FirstFragment : Fragment() {

    private lateinit var viewBinding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = Fragment1Binding.inflate(layoutInflater)
        val viewPager: ViewPager2 = viewBinding.imageViewpager
        val indicator: CircleIndicator3 = viewBinding.indicator

        val adapter = FirstFragmentAdapter(requireActivity())
        viewPager.adapter = adapter

        indicator.setViewPager(viewPager)
        return viewBinding.root
    }
}