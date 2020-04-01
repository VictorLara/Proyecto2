package com.examen.examenrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.tvEdad

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nombre = intent.extras?.getString("nombre","NA")
        val edad = intent.extras?.getInt("edad",0)
        val sexo = intent.extras?.getString("sexo","NA")

        tvNombre.text = "Nombre: "  + nombre;
        tvEdad.text = "Edad: "  + edad.toString();
        tvSexo.text = "Sexo: " + sexo;

        btnEliminar.setOnClickListener() {
            val dialogFragment = EliminarDialogo()
            val ft = supportFragmentManager.beginTransaction()
            val prev = supportFragmentManager.findFragmentByTag("dialog")
            if (prev != null) {
                ft.remove(prev)
            }
            ft.addToBackStack(null)
            dialogFragment.show(ft, "dialog")
        }
    }
}
