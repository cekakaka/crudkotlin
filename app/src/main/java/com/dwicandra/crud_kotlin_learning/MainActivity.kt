package com.dwicandra.crud_kotlin_learning

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dwicandra.crud_kotlin_learning.Adapter.AdapterEmployes
import com.dwicandra.crud_kotlin_learning.DAO.DAOEmployess
import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.FirebaseException
import com.google.firebase.database.*


class MainActivity : AppCompatActivity(){
    lateinit var fab:FloatingActionButton

    private lateinit var daoEmployess: DAOEmployess
  //  lateinit var adapterEmployes: AdapterEmployes
    private lateinit var db : DatabaseReference
    private var listEmployes = ArrayList<Employes>()
    private lateinit var mRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.feb)
        fab.setOnClickListener(listener)

        mRecyclerView = findViewById(R.id.list_employes)
        mRecyclerView.layoutManager =LinearLayoutManager(this)
        mRecyclerView.setHasFixedSize(true)
        getDataListEmployes()

    }
    val listener = View.OnClickListener { view ->
        when(view.id){
            R.id.feb -> {
                val intent = Intent(this@MainActivity, InputActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun getDataListEmployes(){

        daoEmployess = DAOEmployess()
        db = daoEmployess.firebaseConfig()

        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                listEmployes.clear()
                daoEmployess.showData(listEmployes,snapshot)
                if(listEmployes.isNotEmpty()) {
                    mRecyclerView.adapter = AdapterEmployes(this@MainActivity, listEmployes)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"$error", Toast.LENGTH_LONG).show()
            }
        })
    }



}

