package com.rkm.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.rkm.notesapp.database.notesDatabase
import com.rkm.notesapp.datamodel.notes
import com.rkm.notesapp.repository.notesRepository

class NotesviewModel(application: Application):AndroidViewModel(application) {

    val notesRepository:notesRepository

    init {
        val dao=notesDatabase.getdbcopy(application).notesdao()
        notesRepository=notesRepository(dao)
    }


     fun readnote():LiveData<List<notes>>{
        return notesRepository.rreadnotes()
    }

    suspend fun insertnote(notes: notes){
        notesRepository.rinsertnote(notes)
    }

    suspend fun updatenote(notes: notes){
        notesRepository.rupdatenote(notes)
    }

    suspend fun deltenote(id:Int){
        notesRepository.rdeltenote(id)
    }

}