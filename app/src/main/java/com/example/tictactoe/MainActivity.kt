package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var casillas = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        casillas.add(0, R.id.a1)
        casillas.add(1, R.id.a2)
        casillas.add(2, R.id.a3)
        casillas.add(3, R.id.b1)
        casillas.add(4, R.id.b2)
        casillas.add(5, R.id.b3)
        casillas.add(6, R.id.c1)
        casillas.add(7, R.id.c2)
        casillas.add(8, R.id.c3)

    }

    fun aJugar(vista: View) {
        var imagen: ImageView

        casillas.forEach {
            imagen = findViewById(it)
            imagen.setImageResource(R.drawable.casilla)
        }

        var jugadores = 1
        if (vista.id == R.id.btn_2jug) jugadores = 2

        val configDificultad = findViewById<RadioGroup>(R.id.configD)
        val id = configDificultad.checkedRadioButtonId

        var dificultad = 0
        if (id == R.id.rdbtn_normal) dificultad =
            1 else if (id == R.id.rdbtn_imposible) dificultad = 2

        Partida(dificultad)

        //var boton = findViewById<Button>(R.id.btn_1jug).setEnabled(false)
        findViewById<Button>(R.id.btn_1jug).isEnabled = false
        findViewById<RadioGroup>(R.id.configD).alpha = 0F
        findViewById<Button>(R.id.btn_2jug).isEnabled = false

    }
}