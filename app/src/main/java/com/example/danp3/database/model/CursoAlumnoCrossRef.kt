package com.example.danp3.database.model

import androidx.room.Entity


@Entity(primaryKeys = ["CurId", "AluId"])
data class CursoAlumnoCrossRef(
    val CurId: Int,
    val AluId: Int
)