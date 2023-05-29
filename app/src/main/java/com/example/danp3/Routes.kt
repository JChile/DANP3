package com.example.danp3

sealed class Routes(val route: String) {
    object ListaCurso : Routes("lista_curso_screen")
    object ListaAlumno : Routes("lista_alumno_scree")
    object InsertarCurso : Routes("insertar_curso_screen")
    object InsertarAlumno : Routes("insertar_alumno_screen")

}