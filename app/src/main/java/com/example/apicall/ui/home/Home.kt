package com.example.apicall.ui.home

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.apicall.domain.item.GameItem
import androidx.compose.ui.layout.ContentScale

@Composable
fun HomeScreen()
{
    val homeViewModel= viewModel(modelClass = HomeViewModel::class.java)
    val games by homeViewModel.games.collectAsState()

    LazyColumn{
        items(games){game: GameItem ->
            GameCard(game=game)

        }

    }
}
@Composable
fun GameCard(game:GameItem)
{
    val image= rememberImagePainter(data=game.thumbnail)
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    )
    {
        Column {
           Image(painter = image,
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier.fillMaxWidth().height(250.dp)

           )

            Column(modifier = Modifier.padding(10.dp)) {

                Text(text = game.title, fontWeight = FontWeight.Bold)
                Text(text = game.short_description, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Text(text = game.developer, overflow = TextOverflow.Ellipsis,fontWeight = FontWeight.Bold)

            }

        }

    }


}
