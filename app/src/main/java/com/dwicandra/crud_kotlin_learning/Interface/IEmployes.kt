package com.dwicandra.crud_kotlin_learning.Interface

import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import java.io.ObjectInput
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

interface IEmployes {
    fun addEmployess(employee: Employes?): Task<Void?>?
//    fun updateEmployess(key : String, hashMap: HashMap<String,String>): Task<Void?>
    fun showData(employee : ArrayList<Employes>,snapshot: DataSnapshot)
}