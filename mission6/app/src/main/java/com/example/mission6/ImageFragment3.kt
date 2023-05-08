package com.example.mission6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mission6.databinding.Image3Binding

class ImageFragment3 : Fragment() {
    private lateinit var viewBinding: Image3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = Image3Binding.inflate(layoutInflater)
        return viewBinding.root
    }
}