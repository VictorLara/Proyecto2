package com.examen.examenrv

object Singleton {
    val dataSet = arrayListOf<Mascota>()
    var selected : Int = 0;
    var inicializado = false;

    fun add(mascota: Mascota) {
        dataSet.add(mascota)
    }

    fun delete(index: Int) {
        dataSet.removeAt(index)
    }

    fun delete(mascota: Mascota) {
        dataSet.remove(mascota);
    }

    fun deleteSelected() {
        if (selected <= dataSet.size - 1) {
            dataSet.removeAt(selected)
        }
    }
}