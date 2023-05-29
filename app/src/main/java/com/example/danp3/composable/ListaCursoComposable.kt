
package com.example.danp3.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danp3.Routes

@Composable
fun ListaCursoComposable(navController: NavHostController) {

    Text(
        text = "Lista Curso",
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {navController.navigate(Routes.InsertarCurso.route)},
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "añadir curso",
            )
        }
    }
}