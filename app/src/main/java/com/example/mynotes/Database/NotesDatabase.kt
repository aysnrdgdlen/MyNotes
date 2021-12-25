package com.example.mynotes.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotes.Dao.NotesDao

abstract class NotesDatabase : RoomDatabase() {

    abstract fun myNotesDao(): NotesDao

    companion object
    {
        @Volatile
        var INSTANCE:NotesDatabase?=null

        fun getDatabaseInstance(context: Context):NotesDatabase
        {
            val tempInstce = INSTANCE
            if (tempInstce!=null)
            {
                return tempInstce
            }
            synchronized(this)
            {
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, NotesDatabase::class.java, "Notes").build()
                INSTANCE = roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }

}