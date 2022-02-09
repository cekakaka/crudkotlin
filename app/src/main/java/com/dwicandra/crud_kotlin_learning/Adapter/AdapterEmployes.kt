package com.dwicandra.crud_kotlin_learning.Adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.dwicandra.crud_kotlin_learning.InputActivity
import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.dwicandra.crud_kotlin_learning.R
import org.w3c.dom.Text


class AdapterEmployes(val ctx : Context, val datalist: ArrayList<Employes>): RecyclerView.Adapter<AdapterEmployes.EmployesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployesViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view : View = layoutInflater.inflate(R.layout.card_view,parent,false)
        return EmployesViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployesViewHolder, position: Int) {
        holder.bind(ctx,datalist[position])
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class EmployesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvId = itemView.findViewById<TextView>(R.id.tv_id)
        var tvNama = itemView.findViewById<TextView>(R.id.tv_nama)
        val tvKelas = itemView.findViewById<TextView>(R.id.tv_kelas)
        var llrow : LinearLayout = itemView.findViewById(R.id.ll_list)

        fun bind(ctx:Context,employes: Employes) {
            tvId.text = employes.id
            tvNama.text = employes.name
            tvKelas.text = employes.kelas
            llrow.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    val intent = Intent(ctx,InputActivity::class.java)
                    intent.putExtra("id",employes.id)
                    intent.putExtra("name",employes.name)
                    intent.putExtra("kelas",employes.kelas)
                    ctx.startActivity(intent)
                }

            })

        }
    }




}