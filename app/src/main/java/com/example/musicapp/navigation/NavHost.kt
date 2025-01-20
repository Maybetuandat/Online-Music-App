package com.example.musicapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.musicapp.ui.page.About.AboutPage
import com.example.musicapp.ui.page.DetailCategory.DetailCategory
import com.example.musicapp.ui.page.HomePage.HomePage
import com.example.musicapp.ui.page.HomePage.HomePageViewModel
import com.example.musicapp.ui.page.LocationPage.LocationPage
import com.example.musicapp.ui.page.SongPage.SongPage

@Composable
fun NavigationHost(modifier: Modifier, navController: NavHostController, homePageViewModel: HomePageViewModel) {

    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        modifier = modifier
        ) {
        composable(BottomNavItem.Home.route)
        {
            HomePage(homePageViewModel, navController)
        }
        composable(BottomNavItem.Location.route)
        {
            LocationPage()
        }
        composable(BottomNavItem.About.route)
        {
            AboutPage()
        }
        composable(BottomNavItem.Song.route)
        {
            SongPage()
        }
        composable(ScreenItem.DetailsCategory.route)
        {
            DetailCategory()
        }

    }
}
