package com.example.colegiosaltamontes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    //Se instancian los componentes
    var campoDocumento: EditText?=null
    var campoNombre:EditText?=null
    var campoEdad:EditText?=null
    var campoTelefono:EditText?=null
    var campoDireccion:EditText?=null

    var campoMateria1:EditText?=null
    var campoMateria2:EditText?=null
    var campoMateria3:EditText?=null
    var campoMateria4:EditText?=null
    var campoMateria5:EditText?=null
    var campoNota1:EditText?=null
    var campoNota2:EditText?=null
    var campoNota3:EditText?=null
    var campoNota4:EditText?=null
    var campoNota5:EditText?=null
    var operaciones:Operaciones?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        var bundle: Bundle? =this.intent.extras
        operaciones= bundle?.getSerializable("operaciones") as Operaciones
        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        campoDocumento=findViewById(R.id.txtdocumento)
        campoNombre=findViewById(R.id.txtnombre)
        campoEdad=findViewById(R.id.txtedad)
        campoTelefono=findViewById(R.id.txttelefono)
        campoDireccion=findViewById(R.id.txtDireccion)

        campoMateria1=findViewById(R.id.txtMateria1)
        campoMateria2=findViewById(R.id.txtMateria2)
        campoMateria3=findViewById(R.id.txtMateria3)
        campoMateria4=findViewById(R.id.txtMateria4)
        campoMateria5=findViewById(R.id.txtMateria5)

        campoNota1=findViewById(R.id.txtNota1)
        campoNota2=findViewById(R.id.txtNota2)
        campoNota3=findViewById(R.id.txtNota3)
        campoNota4=findViewById(R.id.txtNota4)
        campoNota5=findViewById(R.id.txtNota5)

        var btnRegistro: Button = findViewById(R.id.btnRegistrar)
        var btnVolver: Button = findViewById(R.id.btnVolver)

        btnRegistro.setOnClickListener { registrarEstudiante() }
        btnVolver.setOnClickListener { devolverResultados() }

    }

    private fun registrarEstudiante() {
        var est:Estudiante= Estudiante()
        est.documento= campoDocumento?.text.toString()
        est.nombre=campoNombre?.text.toString()
        est.edad=campoEdad?.text.toString().toInt()
        est.direccion=campoDireccion?.text.toString()
        est.telefono=campoTelefono?.text.toString()

        est.materia1=campoMateria1?.text.toString()
        est.materia2=campoMateria2?.text.toString()
        est.materia3=campoMateria3?.text.toString()
        est.materia4=campoMateria4?.text.toString()
        est.materia5=campoMateria5?.text.toString()

        if( validarNota(campoNota1?.text.toString().toDouble()) or
            validarNota(campoNota2?.text.toString().toDouble()) or
            validarNota(campoNota3?.text.toString().toDouble()) or
            validarNota(campoNota4?.text.toString().toDouble()) or
            validarNota(campoNota5?.text.toString().toDouble())) {
            Toast.makeText(this, "Una de las notas es incorrecta, debe ser entre 0 y 5", Toast.LENGTH_SHORT).show()
        } else {
            est.nota1= campoNota1?.text.toString().toDouble()
            est.nota2= campoNota2?.text.toString().toDouble()
            est.nota3= campoNota3?.text.toString().toDouble()
            est.nota4= campoNota4?.text.toString().toDouble()
            est.nota5= campoNota5?.text.toString().toDouble()
            //Se asigna el promedio delegando el calculo al metodo de la clase operaciones
            est.promedio= operaciones!!.calcularPromedio(est)
            operaciones?.registrarEstudiante(est)
            //Operaciones.listaEstudiantesStatic.add(est)
            Toast.makeText(this, "Estudiante registrado con exito", Toast.LENGTH_SHORT).show()

            var miIntent:Intent= Intent(this,DetalleActivity::class.java)
            var miBundle:Bundle= Bundle()
            miBundle.putSerializable("estudiante",est)
            miBundle.putSerializable("operaciones",operaciones)
            miIntent.putExtras(miBundle)
            startActivity(miIntent)
            finish()
        }
    }

    private fun validarNota(nota: Double): Boolean {
        if (nota < 0 || nota > 5){
            return true;
        }
         return false
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