package com.example.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.navigation.BottomNavigation
import com.example.musicapp.navigation.NavigationHost
import com.example.musicapp.ui.page.HomePage.HomePageViewModel
import com.example.musicapp.ui.theme.MusicAppTheme

class MainActivity : ComponentActivity() {
    private val homePageViewModel = HomePageViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar =
                    {
                        BottomNavigation(navController)
                    }
                )
                { innerPadding ->
                    NavigationHost(Modifier.padding(innerPadding), navController, homePageViewModel)
                }
            }
        }
    }
}

