package com.example.quizuygulamas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
class ogrenci (
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @ColumnInfo(name = "schoolName")
    val schoolNumber: String,
    @ColumnInfo(name = "isTakingCourse")
    var isTakingCourse: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id =0
}