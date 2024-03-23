package com.rkm.notesapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rkm.notesapp.datamodel.notes

@Dao
interface notesDao {

    @Insert
    suspend fun dinsertnote(notes: notes)

    @Query("SELECT * FROM NotesTable")
    fun dreadnotes():LiveData<List<notes>>

    @Update
    suspend fun dupdatenote(notes: notes)

    @Query("DELETE FROM NotesTable WHERE id=:id")
    suspend fun ddeletenote(id:Int)


}