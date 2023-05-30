package com.example.danp3.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Curso")
class CursoEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CurId")
    val CurId: Int = 0,

    @ColumnInfo(name = "CurNam")
    val CurNam: String,
)