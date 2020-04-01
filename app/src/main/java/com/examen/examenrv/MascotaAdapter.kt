package com.examen.examenrv

import android.content.Intent
import android.view.*
import android.view.ContextMenu.ContextMenuInfo
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_item.view.*


class MascotaAdapter():RecyclerView.Adapter<MascotaAdapter.ViewHolder>()  {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener, View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        val tvEdad = v.tvEdad
        val tvNombre =v.tvNombre
        val tvSexo =v.tvSexo

        fun MascotaAdapter(itemView: View) {
            itemView.setOnClickListener(this)
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu, v: View?, menuInfo: ContextMenuInfo? ) {
            val myActionItem = menu.add("Some menu item")
            myActionItem.setOnMenuItemClickListener(this)
        }

        override fun onMenuItemClick(item: MenuItem?): Boolean {
            return true
        }

        override fun onClick(v: View?) {

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_list_item, viewGroup, false)

        return ViewHolder(v)
    }

    override fun getItemCount()=Singleton.dataSet.count()

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener{
            // Toast.makeText(viewHolder.itemView.context,dataSet.get(position).nombre,Toast.LENGTH_LONG).show()
            val intent= Intent(viewHolder.itemView.context, DetailActivity::class.java)
            intent.putExtra("edad", Singleton.dataSet.get(position).edad)
            intent.putExtra("nombre", Singleton.dataSet.get(position).nombre)
            intent.putExtra("sexo", Singleton.dataSet.get(position).sexo)
            Singleton.selected = position;
            viewHolder.itemView.context.startActivity(intent)
        }

        viewHolder.tvNombre.text = "Nombre:  " + Singleton.dataSet[position].nombre
        viewHolder.tvEdad.text = "Edad: " + Singleton.dataSet[position].edad.toString()
        viewHolder.tvSexo.text = "Sexo: " + Singleton.dataSet[position].sexo
    }
}