package com.rkm.notesapp.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import com.rkm.notesapp.R
import com.rkm.notesapp.databinding.FragmentSplashBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSplashBinding.inflate(layoutInflater,container,false)


        Handler(Looper.getMainLooper()).postDelayed(object:Runnable{
            override fun run() {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        },2000)

        return binding.root

    }


}