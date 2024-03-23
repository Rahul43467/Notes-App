package com.rkm.notesapp.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
data class notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val priority:String,
    val title:String,
    val date:String,
    val notes:String)