package misticorp.pe.listadoalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadoproveedores.Bean.AlumnoBean
import kotlinx.android.synthetic.main.activity_main.*
import misticorp.pe.listadoalumnos.Adaptadores.AdaptadorAlumno

class MainActivity : AppCompatActivity() {

lateinit var oAdaptadorAlumno:AdaptadorAlumno
    lateinit var oListaAlumnos:ArrayList<AlumnoBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oListaAlumnos=ArrayList<AlumnoBean>()
        oListaAlumnos.add(AlumnoBean("Santiago","41069772"))
        oListaAlumnos.add(AlumnoBean("Betzi","410697454"))

        oAdaptadorAlumno = AdaptadorAlumno(oListaAlumnos.toList(),this)

        //Atributos del recyledView
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        rvListaAlumnos.setLayoutManager(llm)
        rvListaAlumnos.setHasFixedSize(true)
        rvListaAlumnos.setAdapter(oAdaptadorAlumno)


        //Prueba de texto
    }
}
