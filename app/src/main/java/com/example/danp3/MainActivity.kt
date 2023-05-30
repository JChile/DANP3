package com.example.danp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danp3.composable.ListaAlumnoComposable
import com.example.danp3.composable.ListaCursoComposable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }
    }
}

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Routes.ListaCurso.route)

    {
        composable(route = Routes.ListaCurso.route){
            ListaCursoComposable(navController)
        }

        composable(route = "${Routes.ListaAlumno.route}/{id}") { backStackEntry  ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            ListaAlumnoComposable(navController, id ?: -1)
        }

    }
}