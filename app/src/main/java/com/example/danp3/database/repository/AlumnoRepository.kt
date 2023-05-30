package com.example.danp3.database.repository

import androidx.lifecycle.LiveData
import com.example.danp3.database.dao.AlumnoDao
import com.example.danp3.database.model.AlumnoEntity
import kotlinx.coroutines.flow.Flow

class AlumnoRepository(private val alumnoDao: AlumnoDao) {

    suspend fun insertAlumno(curso: AlumnoEntity){
        alumnoDao.insertAlumno(curso)
    }

}