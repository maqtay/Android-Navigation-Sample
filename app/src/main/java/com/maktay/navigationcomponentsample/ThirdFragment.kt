package com.maktay.navigationcomponentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.maktay.navigationcomponentsample.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(), View.OnClickListener {

    private var binding : FragmentThirdBinding? = null

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third, container, false)
        return binding?.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.goMainButton?.setOnClickListener(this)
    }

    override fun onClick(p0 : View?) {
        when (p0?.id) {
            R.id.goMainButton -> {
                binding?.let {
                    Navigation.findNavController(it.goMainButton)
                        .navigate(R.id.thirdFragment_to_mainFragment)
                }
            }
        }
    }

}