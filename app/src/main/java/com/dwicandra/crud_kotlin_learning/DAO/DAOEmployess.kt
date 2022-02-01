package com.dwicandra.crud_kotlin_learning.DAO

import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DAOEmployess {
    lateinit var database : FirebaseDatabase
    lateinit var myRef : DatabaseReference

    fun firebaseConfig() : DatabaseReference{
        database = FirebaseDatabase.getInstance("https://crudkotlin-b4a3f-default-rtdb.asia-southeast1.firebasedatabase.app/")
        myRef = database.getReference("Employess")
        return myRef
    }

    fun addEmployess(emp: Employes) {
        myRef.push().setValue(emp)
    }

    fun showData(employesList: ArrayList<Employes>, snapshot: DataSnapshot){
        for (snapData in snapshot.children){
            val emp = snapData.getValue(Employes::class.java)
            employesList.add(emp!!)
        }
    }


}