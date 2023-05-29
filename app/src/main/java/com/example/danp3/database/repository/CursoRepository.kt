package com.example.danp3.database.repository

import com.example.danp3.database.dao.CursoDao
import com.example.danp3.database.model.CursoEntity
import kotlinx.coroutines.flow.Flow

class CursoRepository(private val cursoDao: CursoDao) {
    val cursos: Flow<List<CursoEntity>> = cursoDao.getCursos()

    suspend fun insertCurso(curso: CursoEntity){
        cursoDao.insertCurso(curso)
    }

}