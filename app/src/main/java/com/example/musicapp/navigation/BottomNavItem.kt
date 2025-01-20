package com.example.musicapp.navigation

import com.example.musicapp.R

sealed class  BottomNavItem(val label : String, var icon : Int, val route : String) {

    object Home:BottomNavItem("Home", R.drawable.home, "home")
    object Song:BottomNavItem("Song", R.drawable.all_song, "song")
    object Location:BottomNavItem("Location", R.drawable.map_pin, "location")
    object About:BottomNavItem("About", R.drawable.about, "about")
}