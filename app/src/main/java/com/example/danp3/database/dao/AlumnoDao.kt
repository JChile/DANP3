package com.example.danp3.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.danp3.database.model.AlumnoEntity
import com.example.danp3.database.model.CursoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnoDao {

    @Query("SELECT * FROM Alumno")
    fun getAlumnos(): List<AlumnoEntity>

    @Query("SELECT * FROM Alumno WHERE AluId = :id")
    suspend fun getAlumnoById(id: Int): AlumnoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlumno(alumno: AlumnoEntity)

}
