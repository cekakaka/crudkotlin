package com.dwicandra.crud_kotlin_learning.DAO

import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DAOEmployess {
    val database = FirebaseDatabase.getInstance("https://crudkotlin-b4a3f-default-rtdb.asia-southeast1.firebasedatabase.app/")
    val myRef = database.getReference("Employess")

    fun addEmployess(emp: Employes) {
        myRef.push().setValue(emp)
    }

}