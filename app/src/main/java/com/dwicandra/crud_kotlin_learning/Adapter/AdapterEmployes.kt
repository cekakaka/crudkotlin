package com.dwicandra.crud_kotlin_learning.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.dwicandra.crud_kotlin_learning.R
import org.w3c.dom.Text


class AdapterEmployes(val datalist: ArrayList<Employes>): RecyclerView.Adapter<AdapterEmployes.EmployesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployesViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = layoutInflater.inflate(R.layout.card_view,parent,false)
        return EmployesViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployesViewHolder, position: Int) {
        val datalists = datalist[position]
        holder.tvId.text = datalists.id
        holder.tvNama.text = datalists.name
        holder.tvKelas.text = datalists.kelas.toString()
//        holder.tvNama.setText(datalist!![position].name)
//        holder.tvKelas.setText(datalist[position].kelas)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    class EmployesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvId = itemView.findViewById<TextView>(R.id.tv_id)
        var tvNama = itemView.findViewById<TextView>(R.id.tv_nama)
        val tvKelas = itemView.findViewById<TextView>(R.id.tv_kelas)

    }

}