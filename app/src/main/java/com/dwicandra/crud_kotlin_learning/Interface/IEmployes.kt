package com.dwicandra.crud_kotlin_learning.Interface

import com.dwicandra.crud_kotlin_learning.Model.Employes
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface IEmployes {
    fun addEmployess(employee: Employes?): Task<Void?>?
    fun showData(employee : ArrayList<Employes>,snapshot: DataSnapshot)
}