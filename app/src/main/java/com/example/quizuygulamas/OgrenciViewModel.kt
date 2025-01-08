package com.example.quizuygulamas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class OgrenciViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: OgrenciRepository
    val allOgrenciler: LiveData<List<ogrenci>>

    init {
        val ogrenciDao = OgrenciDatabase.getDatabase(application).ogrenciDao()
        repository = OgrenciRepository(ogrenciDao)
        allOgrenciler = repository.allOgrenciler
    }

    fun insert(ogrenci: ogrenci) = viewModelScope.launch {
        repository.insert(ogrenci)
    }
}