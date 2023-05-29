package com.example.danp3.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.danp3.database.model.AppDatabase
import com.example.danp3.database.model.CursoEntity
import com.example.danp3.database.repository.CursoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CursoViewModel(application: Application): AndroidViewModel(application){

    private val cursos: Flow<List<CursoEntity>>
    private val repository: CursoRepository

    init {
        val cursoDao = AppDatabase.getInstance(application).cursoDao()
        repository = CursoRepository(cursoDao)
        cursos = repository.cursos

    }

    fun insertCurso(curso: CursoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCurso(curso)
        }
    }
}