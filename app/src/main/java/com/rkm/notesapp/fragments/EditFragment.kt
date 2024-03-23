package com.rkm.notesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.rkm.notesapp.R
import com.rkm.notesapp.databinding.FragmentEditBinding

/**
 * A simple [Fragment] subclass.
 * Use the [EditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditFragment : Fragment() {

    lateinit var binding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentEditBinding.inflate(layoutInflater,container,false)

        binding.savebutton.setOnClickListener {

            findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }
        return binding.root
    }


}