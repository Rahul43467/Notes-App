package com.rkm.notesapp.fragments


import android.os.Bundle
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.rkm.notesapp.R
import com.rkm.notesapp.adapter.notesAdapter
import com.rkm.notesapp.databinding.FragmentHomeBinding
import com.rkm.notesapp.datamodel.notes
import com.rkm.notesapp.viewmodel.NotesviewModel

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val NotesviewModel:NotesviewModel by viewModels()
    var oldnote = arrayListOf<notes>()
    lateinit var notesadapter: notesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)

        NotesviewModel.readnote().observe(viewLifecycleOwner,{
            oldnote = it as  ArrayList<notes>

             notesadapter=notesAdapter(it,requireContext())
            binding.recyclerView.adapter=notesadapter


        })



        binding.addbutton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editFragment)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                notefilter(newText)
                return true
            }
        })

        return binding.root

    }






    private fun notefilter(newText: String?) {
        val newfilterlist = arrayListOf<notes>()
        for (i in oldnote){
            if(i.title!!.contains(newText!!)|| i.notes!!.contains(newText!!)){
                newfilterlist.add(i)


            }
        }
        notesadapter.filtering(newfilterlist)

    }

}