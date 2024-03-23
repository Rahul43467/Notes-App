package com.rkm.notesapp.repository

import androidx.lifecycle.LiveData
import com.rkm.notesapp.dao.notesDao
import com.rkm.notesapp.datamodel.notes

class notesRepository(val notesDao: notesDao) {


    suspend fun rinsertnote(notes:notes){
        notesDao.dinsertnote(notes)
    }

    fun rreadnotes(): LiveData<List<notes>>{
        return notesDao.dreadnotes()
    }

    suspend fun rupdatenote(notes: notes){
        notesDao.dupdatenote(notes)
    }

    suspend fun rdeltenote(id:Int){
        notesDao.ddeletenote(id)
    }

}