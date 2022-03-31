package com.example.colegiosaltamontes

import java.io.Serializable

class Estudiante : Serializable {

    public var documento: String=""
    public var nombre: String=""
    public var edad: Int=0
    public var telefono: String=""
    public var direccion: String=""

    public var materia1: String=""
    public var materia2: String=""
    public var materia3: String=""
    public var materia4: String=""
    public var materia5: String=""

    public var nota1: Double=0.0
    public var nota2: Double=0.0
    public var nota3: Double=0.0
    public var nota4: Double=0.0
    public var nota5: Double=0.0

    //Este mapa es opcional, es un ejemplo por si se va a gestionar las notas de forma independiente
    var mapaMaterias= mutableMapOf<String,Materia>()

    var promedio:Double=0.0

    override fun toString(): String {
        return "Estudiante(documento='$documento', nombre='$nombre'," +
                " edad=$edad, telefono='$telefono', direccion='$direccion'," +
                " materia1='$materia1', materia2='$materia2', " +
                "materia3='$materia3', materia4='$materia4', materia5='$materia5'," +
                " nota1=$nota1, nota2=$nota2, nota3=$nota3, nota4=$nota4, " +
                "nota5=$nota5, promedio=$promedio)"
    }
}