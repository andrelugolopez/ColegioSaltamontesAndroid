package com.example.colegiosaltamontes

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {

    var operaciones: Operaciones? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        var bundle: Bundle? =this.intent.extras
        var estudiante= bundle?.getSerializable("estudiante") as Estudiante
        operaciones= bundle?.getSerializable("operaciones") as Operaciones

        var textoDocumento: TextView = findViewById(R.id.txtDetalleDocumento)
        var textoNombre:TextView = findViewById(R.id.txtDetalleNombre)
        var textoEdad:TextView = findViewById(R.id.txtDetalleEdad)
        var textoTelefono:TextView = findViewById(R.id.txtDetalleTelefono)
        var textoDireccion:TextView =findViewById(R.id.txtDetalleDireccion)

        var textoMateria1:TextView = findViewById(R.id.txtDetalleMateria1)
        var textoMateria2:TextView = findViewById(R.id.txtDetalleMateria2)
        var textoMateria3:TextView = findViewById(R.id.txtDetalleMateria3)
        var textoMateria4:TextView = findViewById(R.id.txtDetalleMateria4)
        var textoMateria5:TextView = findViewById(R.id.txtDetalleMateria5)

        var textoResultado:TextView = findViewById(R.id.txtDetalleResultadoFinal)
        var textoRecuperable:TextView = findViewById(R.id.txtRecuperable)

        var btnVolver: Button = findViewById(R.id.btnDetalleVolver)
        btnVolver.setOnClickListener { devolverResultados() }

        
        textoDocumento?.setText("Documento: " + estudiante?.documento)
        textoNombre?.setText("Nombre completo: " + estudiante?.nombre)
        textoEdad?.setText("Edad: " + estudiante?.edad)
        textoTelefono?.setText("Telefono: " + estudiante?.telefono)
        textoDireccion?.setText("Dirección: " + estudiante?.direccion)

        textoMateria1?.setText(estudiante?.materia1 + " : " + estudiante?.nota1)
        textoMateria2?.setText(estudiante?.materia2 + " : " + estudiante?.nota2)
        textoMateria3?.setText(estudiante?.materia3 + " : " + estudiante?.nota3)
        textoMateria4?.setText(estudiante?.materia4 + " : " + estudiante?.nota4)
        textoMateria5?.setText(estudiante?.materia5 + " : " + estudiante?.nota5)

        var notaFinal = operaciones!!.calcularPromedio(estudiante)

        if (notaFinal > 3.5) {
            textoResultado?.setText("Aprobó (" + notaFinal + ")")
            textoResultado?.setTextColor(Color.GREEN)
            textoRecuperable?.setText("")
            operaciones!!.cantidadEstudiantesAprobados += 1

        }else {
            textoResultado?.setText("Reprobó (" + notaFinal + ")")
            textoResultado?.setTextColor(Color.RED)
            operaciones!!.cantidadEstudiantesReprobados += 1

            if (notaFinal > 2.5) {
                textoRecuperable?.setText("Recuperable")
                textoRecuperable?.setTextColor(Color.GREEN)
                operaciones!!.cantidadEstudiantesRecuperables += 1
            }else {
                textoRecuperable?.setText("No Recuperable")
                textoRecuperable?.setTextColor(Color.RED)
            }

        }
    }

    private fun devolverResultados(){
        var miIntent: Intent = Intent(this, MainActivity::class.java)
        var miBundle:Bundle= Bundle()
        miBundle.putSerializable("operaciones",operaciones)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
        finish()
    }
}