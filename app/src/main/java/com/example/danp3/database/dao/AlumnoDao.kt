import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.danp3.database.model.AlumnoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnoDao {

    @Query("SELECT * FROM Alumno")
    fun getAlumnos(): Flow<List<AlumnoEntity>>

    @Query("SELECT * FROM Alumno WHERE AluId = :id")
    suspend fun getAlumnosById(id: Int): AlumnoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlumno(curso: AlumnoEntity)

}