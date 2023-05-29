package com.example.danp3.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alumno")
class AlumnoEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "AluId")
    val AluId: Int? = null,

    @ColumnInfo(name = "AluNam")
    val AluNam: String,
    )