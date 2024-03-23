package com.rkm.notesapp.database

import android.content.Context
import androidx.room.Database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.rkm.notesapp.dao.notesDao
import com.rkm.notesapp.datamodel.notes

@Database(entities =[notes::class], version = 1, exportSchema = false)
abstract class notesDatabase():RoomDatabase() {

    abstract fun notesdao():notesDao

    companion object{

        private var INSTANCE: notesDatabase?=null

        fun getdbcopy(context: Context):notesDatabase{

            synchronized(this){

                if(INSTANCE==null){

                    INSTANCE = Room.databaseBuilder(context.applicationContext,notesDatabase::class.java,"notes").build()
                }
            }


            return INSTANCE!!

        }





        }

    }


