package com.example.quizuygulamas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private val ogrenciViewModel: OgrenciViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameEditText = findViewById<EditText>(R.id.firstNameEditText)
        val lastNameEditText = findViewById<EditText>(R.id.lastNameEditText)
        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val courseCheckBox = findViewById<CheckBox>(R.id.courseCheckBox)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val studentListView = findViewById<ListView>(R.id.studentListView)

        val studentListAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ArrayList())
        studentListView.adapter = studentListAdapter

        // Kaydet Butonuna Tıklama Olayı
        saveButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val isTakingCourse = courseCheckBox.isChecked

            if (firstName.isNotBlank() && lastName.isNotBlank() && phone.isNotBlank()) {
                val student = ogrenci(firstName, lastName, phone, isTakingCourse)
                ogrenciViewModel.insert(student)
                Toast.makeText(this, "Öğrenci kaydedildi!", Toast.LENGTH_SHORT).show()
                firstNameEditText.text.clear()
                lastNameEditText.text.clear()
                phoneEditText.text.clear()
                courseCheckBox.isChecked = false
            } else {
                Toast.makeText(this, "Tüm alanları doldurun!", Toast.LENGTH_SHORT).show()
            }
        }

        // Öğrenci listesini gözlemleme
        ogrenciViewModel.allOgrenciler.observe(this, Observer { ogrenciList ->
            val studentNames = ogrenciList.map { "${it.firstName} ${it.lastName} (${it.schoolNumber})" }
            studentListAdapter.clear()
            studentListAdapter.addAll(studentNames)
        })
    }
}
