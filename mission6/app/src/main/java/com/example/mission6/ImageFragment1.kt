package com.example.mission6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mission6.databinding.Image1Binding

class ImageFragment1 : Fragment() {
    private lateinit var viewBinding: Image1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = Image1Binding.inflate(layoutInflater)
        return viewBinding.root
    }
}