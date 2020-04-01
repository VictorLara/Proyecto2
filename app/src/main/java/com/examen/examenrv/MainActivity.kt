package com.examen.examenrv

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        recycler.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recycler.adapter = MascotaAdapter()
        initData()

        floatingActionButton.bringToFront()
        floatingActionButton.setOnClickListener()  {
            Toast.makeText(this@MainActivity, "Nuevo", Toast.LENGTH_LONG).show();
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            R.id.action_salir -> {
                finish();
                moveTaskToBack(true);
                true
            }
            R.id.action_snack -> {
                Snackbar.make(window.decorView.findViewById(android.R.id.content), "Snackbar", Snackbar.LENGTH_LONG)
                    .show();
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initData () {
        if (!Singleton.inicializado) {
            for (i in 1..10) {
                val sexo = if (i%2 == 0 ) "Macho" else "Hembra"
                Singleton.dataSet.add(Mascota("nombre $i", i, sexo))
            }
            Singleton.inicializado = true;
        }
    }
}
