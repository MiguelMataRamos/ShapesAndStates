package com.example.shapesandstates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shapesandstates.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        bind.contador.text = contador.toString()

        bind.buttonSumar.setOnClickListener {
            contador ++
            contar()
        }

        bind.buttonSumar.setOnLongClickListener {
            contador --
            contar()
            true
        }



    }

    private fun contar(){
        bind.contador.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putInt("contador",contador)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        contador = savedInstanceState.getInt("contador")
        contar()
    }


}