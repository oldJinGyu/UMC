package com.example.mission6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mission6.databinding.Fragment1Binding
import com.example.mission6.databinding.MfragmentBinding

class MFragment : Fragment() {
    private lateinit var viewBinding: MfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = MfragmentBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}