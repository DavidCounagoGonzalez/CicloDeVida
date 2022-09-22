package com.example.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    var hrInicial : Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Imprimimos en la ventana del "Logcat"
        Log.d("Estado","Creado")

        setContentView(R.layout.activity_main)

        val miBoton: Button = findViewById(R.id.mi_boton)
        miBoton.text= "Nooooo"

        val miTexto : TextView = findViewById(R.id.text_saludo)
        miTexto.text= getString(R.string.saludo)

    }

    override fun onStart() {
        super.onStart()
        // Imprimimos en la ventana del "Logcat"
        Log.d("Estado","Iniciado")

    }

    override fun onResume() {
        super.onResume()
        // Imprimimos en la ventana del "Logcat"
        Log.d("Estado","Ha vuelto")
        hrInicial = System.nanoTime();
    }

    override fun onPause() {
        super.onPause()
        Log.d("Estado", "Pausada")
        val hrFinal : Long = System.nanoTime()
        val total : Long = (hrFinal - hrInicial)/1000000
        Log.d("Estado","$total")
        hrInicial = 0

        val tiempo : TextView = findViewById(R.id.text_saludo)
        tiempo.text= "La app estuvo activa " + total.toString() +" milisegundos antes de ser pausada."
    }

    override fun onStop() {
        super.onStop()
        Log.d("Estado","App parada")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Estado", "Reiniciado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Estado","Destruida")
    }


}