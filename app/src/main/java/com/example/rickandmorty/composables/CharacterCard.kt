package com.example.rickandmorty.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rickandmorty.models.Result
import com.example.rickandmorty.ui.screens.CharacterDetailScreen
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CharacterCard(result: Result, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("character_detail/${result.id}")
            },
    ) {
        Row(
            modifier = Modifier.background(Color.Gray)
        ) {
            AsyncImage(
                model = result.image,
                contentDescription = result.name,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .clip(MaterialTheme.shapes.medium)
                    .padding(top = 0.dp, bottom = 0.dp, start = 0.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = result.name,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    text = result.species,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Etiqueta de estado
                val statusColor = when (result.status) {
                    "Alive" -> Color.Green
                    "Dead" -> Color.Red
                    else -> Color.Gray
                }

                Text(
                    text = result.status.uppercase(),
                    color = statusColor,
                    modifier = Modifier
                        .background(statusColor.copy(alpha = 0.1f), shape = MaterialTheme.shapes.small)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}



