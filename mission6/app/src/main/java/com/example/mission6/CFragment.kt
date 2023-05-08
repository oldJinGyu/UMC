package com.example.mission6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mission6.databinding.CfragmentBinding
import com.example.mission6.databinding.Fragment1Binding

class CFragment : Fragment() {
    private lateinit var viewBinding: CfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = CfragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}