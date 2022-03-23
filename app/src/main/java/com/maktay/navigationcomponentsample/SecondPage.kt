package com.maktay.navigationcomponentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.maktay.navigationcomponentsample.databinding.FragmentSecondPageBinding

class SecondPage : Fragment(), View.OnClickListener {

    private var binding : FragmentSecondPageBinding? = null
    val args : SecondPageArgs by navArgs()

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
        setData()
    }

    private fun setData() {
        val welcomeText = context?.getString(R.string.please_finish_login, args.fullName)
        binding?.welcome?.text = welcomeText
    }

    override fun onClick(p0 : View?) {
        when (p0?.id) {
            R.id.stop -> {
                binding?.let {
                    val transition = SecondPageDirections.secondPageToThirdFragment(it.phoneNumber.text.toString(), args.fullName)
                    Navigation.findNavController(it.stop).navigate(transition)
                }
            }
        }
    }
}