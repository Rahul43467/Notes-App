package com.rkm.notesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.fragment.findNavController

import com.rkm.notesapp.R
import com.rkm.notesapp.adapter.notesAdapter
import com.rkm.notesapp.databinding.FragmentHomeBinding
import com.rkm.notesapp.viewmodel.NotesviewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val NotesviewModel:NotesviewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)

        NotesviewModel.readnote().observe(viewLifecycleOwner,{

            val notesadapter=notesAdapter(it,requireContext())
            binding.recyclerView.adapter=notesadapter

        })



        binding.addbutton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editFragment)
        }

        return binding.root
    }


}