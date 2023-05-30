package com.example.danp3.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import com.example.danp3.Routes
import com.example.danp3.database.model.AlumnoEntity
import com.example.danp3.database.model.CursoEntity
import com.example.danp3.database.model.CursoWithAlumnos
import com.example.danp3.database.viewmodel.CursoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ListaAlumnoComposable(navController: NavHostController, id: Int) {
    lateinit var mCursoViewModel: CursoViewModel
    mCursoViewModel = ViewModelProvider(LocalContext.current as ViewModelStoreOwner).get(
        CursoViewModel::class.java
    )

    var alumnoList = remember { mutableStateListOf<AlumnoEntity>() }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val cursoWithAlumnos: List<CursoWithAlumnos> = mCursoViewModel.getCursoWithAlumnos(id)
            for (ca in cursoWithAlumnos) {
                alumnoList.addAll(ca.alumnos)
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Lista de cursos",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 60.dp, 10.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            for (alumno in alumnoList) {
                item {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .border(
                                border = BorderStroke(2.dp, Color.LightGray)
                            )
                    ) { listItem(alumno) }
                }
            }
        }

    }
}

@Composable
fun listItem(alumno: AlumnoEntity) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = Color.Cyan)
            .padding(horizontal = 16.dp, vertical = 18.dp)

    ) {
        Row() {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                text = alumno.AluNam,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}