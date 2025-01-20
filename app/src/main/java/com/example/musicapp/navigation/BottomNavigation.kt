package com.example.musicapp.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.musicapp.ui.theme.backgroundcolor
import com.example.musicapp.ui.theme.iconselectedcolor
import com.example.musicapp.ui.theme.iconunselectedcolor

@Composable
fun BottomNavigation(navController: NavController) {
      val navItems = listOf(
          BottomNavItem.Home,
          BottomNavItem.Song,
          BottomNavItem.Location,
          BottomNavItem.About
      )
    NavigationBar(containerColor = backgroundcolor) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        navItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = currentRoute == bottomNavItem.route,
                onClick = {
                    if(currentRoute != bottomNavItem.route)
                    {
                        navController.navigate(bottomNavItem.route){
                            popUpTo(navController.graph.startDestinationId)
                            {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(painter = painterResource(id = bottomNavItem.icon), contentDescription = "Icon")
                },
                label =
                {
                    Text(text = bottomNavItem.label)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = iconunselectedcolor, // Màu cho icon khi không được chọn
                    selectedIconColor = iconselectedcolor,
                    unselectedTextColor = iconunselectedcolor,
                    selectedTextColor = iconselectedcolor
                )
            )
        }
    }
}
