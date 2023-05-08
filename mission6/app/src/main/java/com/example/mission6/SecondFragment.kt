package com.example.mission6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mission6.databinding.Fragment2Binding

class SecondFragment : Fragment() {

    private lateinit var viewBinding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = Fragment2Binding.inflate(layoutInflater)
        return viewBinding.root
    }
}