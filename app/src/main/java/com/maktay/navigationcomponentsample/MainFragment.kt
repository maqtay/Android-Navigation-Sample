package com.maktay.navigationcomponentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.maktay.navigationcomponentsample.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {
    private var binding : FragmentMainBinding? = null

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding?.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.start?.setOnClickListener(this)
    }

    override fun onClick(p0 : View?) {
        when (p0?.id) {
            R.id.start -> {
                binding?.let {
                    val transition = MainFragmentDirections.mainFragmentToSecondPage(it.nameSurname.text.toString())
                    Navigation.findNavController(it.start).navigate(transition)
                }
            }
        }
    }
}