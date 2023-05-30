package com.example.danp3.database.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.danp3.database.dao.CursoDao
import com.example.danp3.database.dao.AlumnoDao
@Database(
    entities = [CursoEntity::class, AlumnoEntity::class, CursoAlumnoCrossRef::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cursoDao(): CursoDao
    abstract fun alumnoDao(): AlumnoDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database-name"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance

                }
                return instance
            }
        }
    }
}