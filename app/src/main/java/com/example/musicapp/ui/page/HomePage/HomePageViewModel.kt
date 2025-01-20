package com.example.musicapp.ui.page.HomePage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.data.model.Category
import com.example.musicapp.data.repository.FireBaseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomePageViewModel:ViewModel() {
    private val fireBaseRepository : FireBaseRepository = FireBaseRepository()
    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories
    init {
              viewModelScope.launch {
                  getCategory()
              }
    }
    private suspend fun getCategory()
    {
           _categories.value = fireBaseRepository.getCategoriesFromFireBase()
        Log.i("Categories", "getCategoryInViewModel: ${categories.value}")
    }

}