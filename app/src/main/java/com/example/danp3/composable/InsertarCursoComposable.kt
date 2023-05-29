package com.example.danp3.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun InsertarCursoComposable(navController: NavHostController) {
    Text(
        text = "Registrar Curso",
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    )


}