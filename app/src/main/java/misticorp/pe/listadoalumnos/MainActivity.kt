package misticorp.pe.listadoalumnos

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadoproveedores.Bean.AlumnoBean
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import misticorp.pe.listadoalumnos.Adaptadores.AdaptadorAlumno

class MainActivity : AppCompatActivity() {

lateinit var oAdaptadorAlumno:AdaptadorAlumno
    lateinit var oListaAlumnos:ArrayList<AlumnoBean>
lateinit var oNuevoAlumno:Dialog

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

    public fun btnNuevoAlumno_Onclick(v: View)
    {
        oNuevoAlumno= Dialog(this)
        oNuevoAlumno.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oNuevoAlumno.setCancelable(false)
        oNuevoAlumno.setContentView(R.layout.activity_nuevo_alumno)
        var obtnGrabarRegistro=oNuevoAlumno.findViewById(R.id.btnGrabarRegistro) as FloatingActionButton
        var obtnCancelarRegistro=oNuevoAlumno.findViewById(R.id.btnCancelarRegistro) as FloatingActionButton

        obtnGrabarRegistro.setOnClickListener()
        {
            GrabarNuevoRegistro()
            oNuevoAlumno.dismiss()
        }
        obtnCancelarRegistro.setOnClickListener {

            oNuevoAlumno.dismiss()
        }


        oNuevoAlumno.show()
    }


    public fun GrabarNuevoRegistro()
    {
        var oedtNombres:EditText=oNuevoAlumno.findViewById(R.id.edtNombresNUEVOALUMNO)
        var oedtDni:EditText=oNuevoAlumno.findViewById(R.id.edtDniNUEVOALUMNO)
        oListaAlumnos.add(AlumnoBean(oedtNombres.text.toString(),oedtDni.text.toString()))

        oAdaptadorAlumno = AdaptadorAlumno(oListaAlumnos.toList(),this)
        rvListaAlumnos.setAdapter(oAdaptadorAlumno)

    }


    public fun btnBuscar_Onclick(v:View)
    {
        VentanaConfirmacion()
    }

    public fun VentanaConfirmacion()
    {
        var oDialogoConfirma:AlertDialog.Builder=AlertDialog.Builder(this)
        oDialogoConfirma.setTitle("Confirmar eliminación de registro")
        oDialogoConfirma.setMessage("¿Estas seguro de eliminar el registro?")
        oDialogoConfirma.setCancelable(false)
        oDialogoConfirma.setPositiveButton(
            "Si",
            DialogInterface.OnClickListener(
                { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                }
            )
        )

        oDialogoConfirma.setNegativeButton(
            "No",
            DialogInterface.OnClickListener(
                { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                }
            )
        )


        var odialogo:AlertDialog=oDialogoConfirma.create()
        odialogo.show()
    }

}
