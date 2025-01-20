package com.example.musicapp.ui.page.HomePage

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.musicapp.R
import com.example.musicapp.data.model.Category
import com.example.musicapp.navigation.ScreenItem
import com.example.musicapp.ui.page.DetailCategory.DetailCategory
import com.example.musicapp.ui.theme.backgroundcolor
import com.example.musicapp.ui.theme.colorBlackBrush
import com.example.musicapp.ui.theme.colorRed
import com.example.musicapp.ui.theme.iconunselectedcolor

@Composable
fun HomePage(viewModel: HomePageViewModel, navController: NavHostController) {

    val categories by viewModel.categories.collectAsState()
//    Log.i("Categories", "HomePage: $categories")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundcolor)
    )
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp)
                .padding(horizontal = 10.dp)
        ) {

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    TopBar()
                }
            }


            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(Color.Transparent)
                ) {
                    Favorite()
                }
            }


            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)

                )
                {
                    RecentlyPlayed()
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
                {
                    CategoryMusic(categories, navController)
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()


                )
                {
                    RecommendForYouScreen()
                }
            }


        }

    }

}

@Composable
fun CategoryMusic(categories: List<Category>, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

            .padding(vertical = 16.dp)
            .padding(start = 5.dp)
    ) {
        // Tiêu đề "Recently Played"
        Text(
            text = "Categories",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Hàng các album
        LazyRow(
            modifier = Modifier.fillMaxHeight()
        ) {
            // Item 1
           items(categories)
           {
               ItemCategory(imageRes = it.coverUrl, title = it.name, navController)
               Spacer(modifier = Modifier
                   .width(20.dp)
                   .fillMaxHeight())

           }

        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemCategory(imageRes: String, title: String, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(120.dp) // Độ rộng mỗi item
            .clickable {
                navController.navigate(ScreenItem.DetailsCategory.route)
            }

    ) {
        // Hình ảnh album
        GlideImage(
            model = imageRes,
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp) // Kích thước hình
                .clip(RoundedCornerShape(12.dp)) // Bo góc
                .border(
                    width = 2.dp,
                    color = Color.Cyan, // Viền màu xanh
                    shape = RoundedCornerShape(12.dp)
                )

        )

        // Tiêu đề album
        Text(
            text = title,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun RecentlyPlayed() {
    Column(
        modifier = Modifier
            .fillMaxWidth()

            .padding(vertical = 16.dp)
            .padding(start = 5.dp)
    ) {
        // Tiêu đề "Recently Played"
        Text(
            text = "Recently Played",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Hàng các album
        LazyRow(
            modifier = Modifier.fillMaxHeight()
        ) {
            // Item 1
            item {
                ItemRecentlyPlayed(
                    imageRes = R.drawable.album1, // Thay thế bằng ID hình ảnh của bạn
                    title = "The triangle"
                )
                Spacer(modifier = Modifier
                    .width(20.dp)
                    .fillMaxHeight())
            }


            // Item 2
            item {
                ItemRecentlyPlayed(
                    imageRes = R.drawable.album1, // Thay thế bằng ID hình ảnh của bạn
                    title = "Dune Of Visa"
                )
                Spacer(modifier = Modifier
                    .width(20.dp)
                    .fillMaxHeight())
            }


            // Item 3
            item{
                ItemRecentlyPlayed(
                    imageRes = R.drawable.album1, // Thay thế bằng ID hình ảnh của bạn
                    title = "Riskitall"
                )
                Spacer(modifier = Modifier
                    .width(20.dp)
                    .fillMaxHeight())
            }
           item{
               ItemRecentlyPlayed(
                   imageRes = R.drawable.album1, // Thay thế bằng ID hình ảnh của bạn
                   title = "Riskitall"
               )

           }

        }
    }
}

@Composable
fun ItemRecentlyPlayed(imageRes: Int, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp) // Độ rộng mỗi item
    ) {
        // Hình ảnh album
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp) // Kích thước hình
                .clip(RoundedCornerShape(12.dp)) // Bo góc
                .border(
                    width = 2.dp,
                    color = Color.Cyan, // Viền màu xanh
                    shape = RoundedCornerShape(12.dp)
                )
        )

        // Tiêu đề album
        Text(
            text = title,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Favorite() {

    // Tạo Brush gradient (đỏ và xám)
    val gradientBrush = Brush.linearGradient(
        colors = listOf(colorRed, colorBlackBrush),
        start = Offset(0f, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY)
    )


    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Box(
            modifier = Modifier
                .background(brush = gradientBrush)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.heart),
                        tint = Color.Red.copy(0.5f),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Your likes",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                Icon(
                    painter = painterResource(R.drawable.shuffle),
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            color = backgroundcolor,
                            shape = CircleShape
                        )
                        .padding(5.dp)
                )
            }
        }
    }

}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )
        {
            Text(
                text = "Home", color = Color.White, fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )
        {

            val sizeIcon = 25.dp
            Icon(
                painterResource(R.drawable.cast), contentDescription = null,
                tint = iconunselectedcolor,
                modifier = Modifier
                    .height(sizeIcon)
                    .width(sizeIcon)
            )


            Icon(
                painterResource(R.drawable.upload), contentDescription = null,
                tint = iconunselectedcolor,
                modifier = Modifier
                    .height(sizeIcon)
                    .width(sizeIcon)
            )


            Icon(
                painterResource(R.drawable.email), contentDescription = null,
                tint = iconunselectedcolor,
                modifier = Modifier
                    .height(sizeIcon)
                    .width(sizeIcon)
            )


            Icon(
                painterResource(R.drawable.notification),
                contentDescription = null,
                tint = iconunselectedcolor,
                modifier = Modifier
                    .height(sizeIcon)
                    .width(sizeIcon)
            )

        }
    }
}


@Composable
fun RecommendForYouScreen() {
    val songs = listOf(
        Song("The stranger inside you", "Jeane Lebras", "114k / streams", R.drawable.album1),
        Song("Edwall of beauty mind", "Jacob Givson", "44.3k / streams", R.drawable.album1),
        Song("Song Title Example", "Artist Name", "20k / streams", R.drawable.album1)
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Recommend for you",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            songs.forEach { song ->
                SongItem(song)
            }
        }

    }
}

@Composable
fun SongItem(song: Song) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Album cover image
        Image(
            painter = painterResource(id = song.albumCover),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Song details
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = song.title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = song.artist,
                color = Color.Gray,
                fontSize = 14.sp
            )
            Text(
                text = song.streams,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}

data class Song(
    val title: String,
    val artist: String,
    val streams: String,
    val albumCover: Int
)
