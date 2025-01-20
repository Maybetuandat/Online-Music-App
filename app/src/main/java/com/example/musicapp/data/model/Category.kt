package com.example.musicapp.data.model

data class Category(
    val name: String,
    val coverUrl: String,
    val songs: List<String>
){
    constructor(): this("", "", listOf())

}