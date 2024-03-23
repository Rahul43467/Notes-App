package com.rkm.notesapp.fragments

import android.os.Bundle
import android.text.format.DateFormat


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rkm.notesapp.R
import com.rkm.notesapp.databinding.FragmentUpdateBinding
import com.rkm.notesapp.datamodel.notes
import com.rkm.notesapp.viewmodel.NotesviewModel
import kotlinx.coroutines.launch

import java.util.Date

/**
 * A simple [Fragment] subclass.
 * Use the [UpdateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateFragment : Fragment() {

    lateinit var binding: FragmentUpdateBinding
    val NotesviewModel: NotesviewModel by viewModels()


    val notedata by navArgs<UpdateFragmentArgs>()
    // TODO: Rename and change types of parameters

    var priority="1"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(layoutInflater,container,false)
        binding.title.setText(notedata.data.title)
        priority = notedata.data.priority.toString()
        binding.notes.setText(notedata.data.notes)
            when (notedata.data.priority){
              "1"->{
                  binding.redpriority.setImageResource(R.drawable.yes)
              }
              "2"->{
                  binding.greenpriority.setImageResource(R.drawable.yes)
              }

            }
        binding.redpriority.setOnClickListener {
            priority="1"
            binding.greenpriority.setImageResource(0)
            binding.redpriority.setImageResource(R.drawable.yes)
        }

        binding.greenpriority.setOnClickListener {
            priority="2"
            binding.greenpriority.setImageResource(R.drawable.yes)
            binding.redpriority.setImageResource(0)
        }
        binding.updatebutton.setOnClickListener {

            updatedata()

            findNavController().navigate(R.id.action_updateFragment_to_homeFragment)

        }
        binding.deletebutton.setOnClickListener {
            deletedata()

            findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
        }
        return binding.root
    }

    private fun deletedata() {
        lifecycleScope.launch {
            notedata.data.id?.let { NotesviewModel.deltenote(it) }

        }

    }

    private fun updatedata() {
        binding.apply {

            val title= title.text.toString()
            val note= notes.text.toString()
            val d= Date()
            val date:CharSequence = DateFormat.format("MMMM d",d.time)
            val notes= notes( notedata.data.id,priority,title,date.toString(),note)
            lifecycleScope.launch {
                NotesviewModel.updatenote(notes)

            }




        }
    }


}