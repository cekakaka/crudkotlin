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


class AdapterEmployes(datalist: ArrayList<Employes>?): RecyclerView.Adapter<AdapterEmployes.EmployesViewHolder>(){
    private val datalist : ArrayList<Employes>?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployesViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = layoutInflater.inflate(R.layout.card_view,parent,false)
        return EmployesViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployesViewHolder, position: Int) {
        holder.tvNama.setText(datalist!![position].name)
        holder.tvKelas.setText(datalist[position].kelas)
    }

    override fun getItemCount(): Int {
        return if(datalist != null) datalist.size else 0
    }

    inner class EmployesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvNama: TextView
        val tvKelas: TextView

        init {
            tvNama = itemView.findViewById(R.id.tv_nama) as TextView
            tvKelas = itemView.findViewById(R.id.tv_kelas) as TextView
        }
    }

    init {
        this.datalist = datalist
    }

}