package com.maktay.navigationcomponentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.maktay.navigationcomponentsample.databinding.FragmentSecondPageBinding

class SecondPage : Fragment(), View.OnClickListener {

    private var binding : FragmentSecondPageBinding? = null

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_page, container, false)
        return binding?.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.stop?.setOnClickListener(this)
    }

    override fun onClick(p0 : View?) {
        when (p0?.id) {
            R.id.stop -> {
                binding?.let {
                    Navigation.findNavController(it.stop).navigate(R.id.secondPage_to_thirdFragment)
                }
            }
        }
    }
}