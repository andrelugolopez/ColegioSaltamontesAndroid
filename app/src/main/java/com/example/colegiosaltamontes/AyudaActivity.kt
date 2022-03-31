package com.example.colegiosaltamontes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AyudaActivity : AppCompatActivity() {

    var operaciones:Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)
        var bundle: Bundle? =this.intent.extras
        operaciones = bundle?.getSerializable("operaciones") as Operaciones

        var btnVolver: Button = findViewById(R.id.btnAyudaVolver)
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