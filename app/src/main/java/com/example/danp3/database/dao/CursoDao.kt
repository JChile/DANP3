package com.example.danp3.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.danp3.database.model.CursoAlumnoCrossRef
import com.example.danp3.database.model.CursoEntity
import com.example.danp3.database.model.CursoWithAlumnos
import kotlinx.coroutines.flow.Flow

@Dao
interface CursoDao {

    @Query("SELECT * FROM Curso")
    fun getCursos(): List<CursoEntity>

    @Query("SELECT * FROM Curso WHERE CurId = :id")
    suspend fun getCursoById(id: Int): CursoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurso(curso: CursoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCursoAlumnoCrossRef(crossRef: CursoAlumnoCrossRef)

    @Transaction
    @Query("SELECT * FROM Curso WHERE CurId = :id")
    suspend fun getCursoWithAlumnos(id: Int): List<CursoWithAlumnos>

}
