package com.example.colegiosaltamontes

import java.io.Serializable

class Operaciones : Serializable {
    var cantidadEstudiantesAprobados = 0
    var cantidadEstudiantesReprobados = 0
    var cantidadEstudiantesRecuperables = 0
    var listaEstudiantes: ArrayList<Estudiante> =arrayListOf<Estudiante>()

    fun registrarEstudiante(estudiante: Estudiante){

        listaEstudiantes.add(estudiante)
    }

    fun calcularPromedio(est: Estudiante): Double {

        var prom=(est.nota1+est.nota2+est.nota3+est.nota4+est.nota5)/5

        return prom
    }
}