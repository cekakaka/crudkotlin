package com.dwicandra.crud_kotlin_learning.DAO

import androidx.annotation.VisibleForTesting
import com.dwicandra.crud_kotlin_learning.Interface.IEmployes
import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.ObjectInput
import java.sql.Struct
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DAOEmployess : IEmployes{
    lateinit var database : FirebaseDatabase
    lateinit var myRef : DatabaseReference

    fun firebaseConfig() : DatabaseReference{
        database = FirebaseDatabase.getInstance("https://crudkotlin-b4a3f-default-rtdb.asia-southeast1.firebasedatabase.app/")
        myRef = database.getReference("Employess")
        return myRef
    }

    override fun addEmployess(employee: Employes?): Task<Void?>? {
        return myRef.push().setValue(employee)
    }

//    override fun updateEmployess(key: String, hashMap: HashMap<String, String>): Task<Void?> {
//        return myRef.child(key).setValue("Employess")
//    }

    override fun showData(employesList: ArrayList<Employes>, snapshot: DataSnapshot) {
        for (snapData in snapshot.children) {
            val emp = snapData.getValue(Employes::class.java)
            employesList.add(emp!!)
        }
    }


}