package com.example.colegiosaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var operaciones: Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_ColegioSaltaMontes)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bundle: Bundle? = this.intent.extras

        if (bundle == null ){
            operaciones = Operaciones()
        }else {
            operaciones= bundle?.getSerializable("operaciones") as Operaciones
        }
        iniciarComponentes()

    }

    private fun iniciarComponentes() {
        val botonRegistro: Button = findViewById(R.id.btnRegistro)
        val botonEstadisticas:Button = findViewById(R.id.btnEstadisticas)
        val botonAyuda:Button = findViewById(R.id.btnAyuda)

        botonRegistro.setOnClickListener { onClickRegistro() }
        botonAyuda.setOnClickListener { onClickAyuda() }
        botonEstadisticas.setOnClickListener { onClickEstadistica() }
    }

    private fun onClickRegistro() {
        var miIntent:Intent= Intent(this,RegistroActivity::class.java)
        var miBundle:Bundle= Bundle()
        miBundle.putSerializable("operaciones", operaciones)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
        finish()
    }

    private fun onClickEstadistica() {
        var miIntent:Intent= Intent(this,EstadisticasActivity::class.java)
        var miBundle:Bundle= Bundle()
        miBundle.putSerializable("operaciones", operaciones)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
        finish()
    }

    private fun onClickAyuda() {
        var miIntent:Intent= Intent(this,AyudaActivity::class.java)
        var miBundle:Bundle= Bundle()
        miBundle.putSerializable("operaciones", operaciones)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
        finish()
    }
}












