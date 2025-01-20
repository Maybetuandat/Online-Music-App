package com.example.musicapp.data.repository

import android.util.Log
import com.example.musicapp.data.model.Category
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FireBaseRepository{
    suspend  fun getCategoriesFromFireBase(): List<Category> {
         return try {
             val snapshot = FirebaseFirestore.getInstance()
                 .collection("category")
                 .get()
                 .await()
             snapshot.toObjects(Category::class.java)
         }
         catch (e: Exception) {
             Log.e("FireBaseRepository", "Error fetching categories: ${e.message}")
             emptyList()
         }
    }
}

