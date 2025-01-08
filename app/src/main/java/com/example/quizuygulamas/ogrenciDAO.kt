package com.example.quizuygulamas

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OgrenciDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ogrenci: ogrenci)

    @Query("SELECT * FROM student_table")
    fun getAllOgrenciler(): LiveData<List<ogrenci>>
}