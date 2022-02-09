package com.dwicandra.crud_kotlin_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.dwicandra.crud_kotlin_learning.DAO.DAOEmployess
import com.dwicandra.crud_kotlin_learning.Model.Employes
import java.util.*
import kotlin.collections.ArrayList

class InputActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var etNama: EditText
    lateinit var etKelas: EditText
    lateinit var btnSubmit: Button
    lateinit var btnUpdate: Button
    var dao = DAOEmployess()
    lateinit var listEmployes:MutableList<Employes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        etNama = findViewById(R.id.et_nama)
        etKelas = findViewById(R.id.et_kelas)
        btnSubmit = findViewById(R.id.btn_submit)
        btnSubmit.setOnClickListener(this)

        btnUpdate = findViewById(R.id.btn_update)

        var bundle : Bundle? = intent.extras
        etNama.setText(bundle?.getString("name"))
        etKelas.setText(bundle?.getString("kelas"))

        btnUpdate.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                var dao = dao.firebaseConfig()
                val nama = etNama.text.toString().trim()
                val kelas = etKelas.text.toString().trim()
                val employesId = dao.key
                var employes = Employes(employesId!!,nama,kelas)
                dao.child(employes.id!!).setValue(employes)
                Toast.makeText(applicationContext, "Update jalan", Toast.LENGTH_SHORT).show()
            }
        })



    }
    override fun onClick(p0: View?) {
        saveData()
    }

    fun saveData() {
        val nama = etNama.text.toString().trim()
        val kelas = etKelas.text.toString().trim()
        if(nama.isEmpty()){
            etNama.error = "isi nama"
            return
        }
        if(kelas.isEmpty()){
            etKelas.error = "Isi Kelas"
            return
        }
        val employesId = dao.firebaseConfig().push().key
        val emp = Employes(employesId!!,nama,kelas)
        dao.addEmployess(emp)
        if(dao != null){
            Toast.makeText(applicationContext,"Data Berhasil Ditambah ",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext,"Data Tidak Berhasil Ditambah ",Toast.LENGTH_SHORT).show()
        }
    }

}