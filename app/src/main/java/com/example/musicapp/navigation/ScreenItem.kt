package com.example.musicapp.navigation

sealed class ScreenItem(val route : String, val name : String) {
    object DetailsCategory : ScreenItem("Detail Category", "detailscategory")
}