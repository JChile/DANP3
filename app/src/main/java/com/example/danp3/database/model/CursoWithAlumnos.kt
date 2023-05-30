package com.example.danp3.database.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CursoWithAlumnos (
    @Embedded val curso: CursoEntity,
    @Relation(
        parentColumn = "CurId",
        entityColumn = "AluId",
        associateBy = Junction(CursoAlumnoCrossRef :: class)
    )
    val alumnos: List<AlumnoEntity>
)