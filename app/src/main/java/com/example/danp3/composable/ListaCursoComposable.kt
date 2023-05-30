
package com.example.danp3.composable

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.NavHostController
import com.example.danp3.Routes
import com.example.danp3.database.model.AlumnoEntity
import com.example.danp3.database.model.CursoAlumnoCrossRef
import com.example.danp3.database.model.CursoEntity
import com.example.danp3.database.viewmodel.AlumnoViewModel
import com.example.danp3.database.viewmodel.CursoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.withContext
import java.util.Random

val cursos = listOf("Matematica", "Quimica", "Fisica", "Ingles", "Historia")
data class Alumno(val nombre: String, val apellido: String)

val alumnos = listOf(
    Alumno("Lucas", "Gómez"),
    Alumno("Sofía", "Rodríguez"),
    Alumno("Benjamín", "Hernández"),
    Alumno("Isabella", "García"),
    Alumno("Matías", "López"),
    Alumno("Valentina", "Martínez"),
    Alumno("Sebastián", "Pérez"),
    Alumno("Emma", "Sánchez"),
    Alumno("Martín", "González"),
    Alumno("Mía", "Torres"),
    Alumno("Joaquín", "Flores"),
    Alumno("Valeria", "Rivera"),
    Alumno("Miguel", "Morales"),
    Alumno("Camila", "Ortega"),
    Alumno("Emmanuel", "Silva"),
    Alumno("Lucía", "Cruz"),
    Alumno("Santiago", "Ruiz"),
    Alumno("Emily", "Molina"),
    Alumno("Emilio", "Vargas"),
    Alumno("Gabriela", "Ramírez"),
    Alumno("Nicolás", "Reyes"),
    Alumno("Victoria", "Acosta"),
    Alumno("Diego", "Chávez"),
    Alumno("Alejandra", "Peña"),
    Alumno("Felipe", "Jiménez"),
    Alumno("Ximena", "Rojas"),
    Alumno("Daniel", "Navarro"),
    Alumno("Daniela", "Guerrero"),
    Alumno("Hugo", "Cortés"),
    Alumno("María", "Olivares"),
    Alumno("Andrés", "Castro"),
    Alumno("Paula", "Lara"),
    Alumno("Pedro", "Mendoza"),
    Alumno("Ana", "Fuentes"),
    Alumno("Juan", "Cervantes"),
    Alumno("Laura", "Santana")
)
@Composable
fun ListaCursoComposable(navController: NavHostController) {

    lateinit var mCursoViewModel: CursoViewModel
    mCursoViewModel = ViewModelProvider(LocalContext.current as ViewModelStoreOwner).get(CursoViewModel::class.java)

    lateinit var mAlumnoViewModel: AlumnoViewModel
    mAlumnoViewModel = ViewModelProvider(LocalContext.current as ViewModelStoreOwner).get(AlumnoViewModel::class.java)

    var cursosList = remember { mutableStateListOf<CursoEntity>() }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            cursosList.addAll(mCursoViewModel.getCursos())
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

        Button(onClick = {
            InsertarDatos(mCursoViewModel, mAlumnoViewModel)
        },
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Icon",
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text("AGREGAR")
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 60.dp, 10.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            for (curso in cursosList) {
                item {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .border(
                                border = BorderStroke(2.dp, Color.LightGray)
                            )
                    ) { listItemRow(curso, navController)}
                }
            }
        }

    }


}

@Composable
fun listItemRow(curso: CursoEntity, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = Color.LightGray)
            .padding(horizontal = 16.dp, vertical = 18.dp)
            .clickable {
                navController.navigate("${Routes.ListaAlumno.route}/${curso.CurId}")
            }
    ) {
        Row() {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                text = curso.CurNam,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun InsertarDatos(mCursoViewModel: CursoViewModel, mAlumnoViewModel: AlumnoViewModel){
    for (c in cursos) {
        val cursoEntity = CursoEntity(CurNam = c)
        mCursoViewModel.insertCurso(cursoEntity)
    }

    for(a in alumnos) {
        val alumnoEntity = AlumnoEntity(AluNam = a.nombre, AluApe = a.apellido)
        mAlumnoViewModel.insertAlumno(alumnoEntity)
    }

    val tamañoCursos = cursos.size
    val tamañoAlumnos = alumnos.size
    val random = Random(System.currentTimeMillis())

    for (i in 1 .. tamañoAlumnos) {
        for (j in 1 .. 5) {
            val indiceAleatorio = random.nextInt(tamañoCursos)
            val cursoAlumnoCrossRef = CursoAlumnoCrossRef(CurId = indiceAleatorio, AluId = i)
            mCursoViewModel.insertCursoAlumnoCrossRef(cursoAlumnoCrossRef)
        }
    }
}
