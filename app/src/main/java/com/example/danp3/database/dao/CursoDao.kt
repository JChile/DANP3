package com.example.danp3.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.danp3.database.model.CursoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CursoDao {

    @Query("SELECT * FROM Curso")
    fun getCursos(): Flow<List<CursoEntity>>

    @Query("SELECT * FROM Curso WHERE CurId = :id")
    suspend fun getCursoById(id: Int): CursoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurso(curso: CursoEntity)

}
