package com.example.quizuygulamas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ogrenci::class], version = 1, exportSchema = false)
abstract class OgrenciDatabase : RoomDatabase() {
    abstract fun ogrenciDao(): OgrenciDao

    companion object {
        @Volatile
        private var INSTANCE: OgrenciDatabase? = null

        fun getDatabase(context: Context): OgrenciDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OgrenciDatabase::class.java,
                    "ogrenci_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}