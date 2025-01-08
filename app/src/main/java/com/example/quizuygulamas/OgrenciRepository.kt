package com.example.quizuygulamas

import androidx.lifecycle.LiveData

class OgrenciRepository(private val ogrenciDao: OgrenciDao) {
    val allOgrenciler: LiveData<List<ogrenci>> = ogrenciDao.getAllOgrenciler()

    suspend fun insert(ogrenci: ogrenci) {
        ogrenciDao.insert(ogrenci)
    }
}