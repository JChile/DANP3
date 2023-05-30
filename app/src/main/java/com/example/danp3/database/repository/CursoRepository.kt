package com.example.danp3.database.repository

import androidx.lifecycle.LiveData
import com.example.danp3.database.dao.CursoDao
import com.example.danp3.database.model.CursoAlumnoCrossRef
import com.example.danp3.database.model.CursoEntity
import com.example.danp3.database.model.CursoWithAlumnos
import kotlinx.coroutines.flow.Flow

class CursoRepository(private val cursoDao: CursoDao) {
    suspend fun getCursos(): List<CursoEntity>{
        return cursoDao.getCursos();
    }
    suspend fun insertCurso(curso: CursoEntity){
        cursoDao.insertCurso(curso)
    }

    suspend fun getCursoWithAlumnos(id: Int): List<CursoWithAlumnos>{
        return cursoDao.getCursoWithAlumnos(id)
    }

    suspend fun insertCursoAlumnoCrossRef(crossRef: CursoAlumnoCrossRef){
        cursoDao.insertCursoAlumnoCrossRef(crossRef)
    }

}