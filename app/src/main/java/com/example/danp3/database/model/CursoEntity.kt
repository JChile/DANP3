package com.example.danp3.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Curso")
class CursoEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CurId")
    val CurId: Int? = null,

    @ColumnInfo(name = "CurNam")
    val CurNam: String,
)