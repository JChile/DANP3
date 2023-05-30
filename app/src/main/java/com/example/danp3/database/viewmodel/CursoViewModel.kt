package com.example.danp3.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.danp3.database.model.AppDatabase
import com.example.danp3.database.model.CursoAlumnoCrossRef
import com.example.danp3.database.model.CursoEntity
import com.example.danp3.database.model.CursoWithAlumnos
import com.example.danp3.database.repository.CursoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CursoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: CursoRepository

    init {
        val cursoDao = AppDatabase.getInstance(application).cursoDao()
        repository = CursoRepository(cursoDao)
    }

    suspend fun getCursoWithAlumnos(id: Int): List<CursoWithAlumnos>{
        return repository.getCursoWithAlumnos(id)
    }
    suspend fun getCursos(): List<CursoEntity>{
        return repository.getCursos();
    }

    fun insertCurso(curso: CursoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCurso(curso)
        }
    }

    fun insertCursoAlumnoCrossRef(crossRef: CursoAlumnoCrossRef) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCursoAlumnoCrossRef(crossRef)
        }
    }
}