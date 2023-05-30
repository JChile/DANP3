package com.example.danp3.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.danp3.database.model.AlumnoEntity
import com.example.danp3.database.model.AppDatabase
import com.example.danp3.database.model.CursoEntity
import com.example.danp3.database.repository.AlumnoRepository
import com.example.danp3.database.repository.CursoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class AlumnoViewModel(application: Application): AndroidViewModel(application){

    private val repository: AlumnoRepository

    init {
        val alumnoDao = AppDatabase.getInstance(application).alumnoDao()
        repository = AlumnoRepository(alumnoDao)
    }

    fun insertAlumno(alumno: AlumnoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAlumno(alumno)
        }
    }
}