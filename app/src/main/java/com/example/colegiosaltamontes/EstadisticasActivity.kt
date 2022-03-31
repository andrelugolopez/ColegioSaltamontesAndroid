package com.example.colegiosaltamontes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EstadisticasActivity : AppCompatActivity() {

    var operaciones:Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)
        var bundle: Bundle? =this.intent.extras
        operaciones = bundle?.getSerializable("operaciones") as Operaciones

        var textoCantidadProcesados: TextView = findViewById(R.id.txtCantidadProcesados)
        var textoCantidadAprobados: TextView = findViewById(R.id.txtCantidadAprobados)
        var textoCantidadReprobados: TextView = findViewById(R.id.txtCantidadReprobados)
        var textoCantidadRecuperables: TextView = findViewById(R.id.txtCantidadRecuperables)

        textoCantidadProcesados?.setText("Total Procesados: " + operaciones!!.listaEstudiantes.size)
        textoCantidadAprobados?.setText("Total Aprobados: " + operaciones!!.cantidadEstudiantesAprobados)
        textoCantidadReprobados?.setText("Total Reprobados: " + operaciones!!.cantidadEstudiantesReprobados)
        textoCantidadRecuperables?.setText("Total Recuperables: " + operaciones!!.cantidadEstudiantesRecuperables)

        var btnVolver: Button = findViewById(R.id.btnEstadisticasVolver)
        btnVolver.setOnClickListener { devolverResultados() }
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