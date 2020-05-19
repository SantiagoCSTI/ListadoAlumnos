package com.example.listadoproveedores.Bean

public class AlumnoBean {
    var CodigoAlumuno:Int=0
    var Nombres:String=""
    var DNI:String =""

    public constructor()
    {
        this.LimpiarPropiedades()
    }

    public constructor(pNombres:String, pDni: String)
    {
        this.Nombres=pNombres
        this.DNI = pDni
    }

    fun LimpiarPropiedades()
    {
        this.CodigoAlumuno=0
        this.Nombres=""
        this.DNI=""
    }

}