package misticorp.pe.listadoalumnos.Adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadoproveedores.Bean.AlumnoBean
import kotlinx.android.synthetic.main.registroalumno.view.*
import misticorp.pe.listadoalumnos.R

public class AdaptadorAlumno(val ListaInterna:List<AlumnoBean>, Contexto:Context) :
    RecyclerView.Adapter<AdaptadorAlumno.AlumnoBeanHolder>()
{

    public class AlumnoBeanHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oAlumno:AlumnoBean)
        {
            val oTvCodigo=itemView.findViewById(R.id.TVITEM_CODIGO_ALUMNO) as TextView
            val oTvDNI=itemView.findViewById(R.id.TVITEM_DNI_ALUMNO) as TextView
            val oTvNombres=itemView.findViewById(R.id.TVITEM_NOMBRES_ALUMNO) as TextView

            oTvCodigo.text = oAlumno.CodigoAlumuno.toString()
            oTvDNI.text = oAlumno.DNI
            oTvNombres.text = oAlumno.Nombres
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoBeanHolder {
        val v:View=LayoutInflater.from(parent?.context)
            .inflate(R.layout.registroalumno, parent,false)
        return AlumnoBeanHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaInterna.size
    }

    override fun onBindViewHolder(holder: AlumnoBeanHolder, position: Int) {
        holder?.itemView?.TVITEM_CODIGO_ALUMNO?.text = ListaInterna.get(position).CodigoAlumuno.toString()
        holder?.itemView?.TVITEM_DNI_ALUMNO?.text = ListaInterna.get(position).DNI
        holder?.itemView?.TVITEM_NOMBRES_ALUMNO?.text = ListaInterna.get(position).Nombres
    }

}