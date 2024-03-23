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

import com.rkm.notesapp.R
import com.rkm.notesapp.databinding.FragmentEditBinding
import com.rkm.notesapp.datamodel.notes
import com.rkm.notesapp.viewmodel.NotesviewModel
import kotlinx.coroutines.launch
import java.util.Date

/**
 * A simple [Fragment] subclass.
 * Use the [EditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditFragment : Fragment() {

    lateinit var binding: FragmentEditBinding

    val NotesviewModel: NotesviewModel by viewModels()

    var priority="1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentEditBinding.inflate(layoutInflater,container,false)

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

        binding.savebutton.setOnClickListener {

            savenote()

            findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }
        return binding.root
    }

    private fun savenote() {
        binding.apply {

           val title= title.text.toString()
            val note= notes.text.toString()
            val d= Date()
            val date:CharSequence =DateFormat.format("MMM d,YYYY",d.time)
            val notes=notes(null ,priority,title,date.toString(),note)

            lifecycleScope.launch {
                NotesviewModel.insertnote(notes)

            }



        }
    }


}