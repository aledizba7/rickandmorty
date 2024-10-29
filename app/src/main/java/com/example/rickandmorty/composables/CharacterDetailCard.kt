package com.example.rickandmorty.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.models.Result

@Composable
fun CharacterDetailCard(character: Result) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors= CardDefaults.cardColors(containerColor = Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Gray)
        ) {
            CharacterDetailRow("Name:", character.name)
            CharacterDetailRow("Species:", character.species)
            CharacterDetailRow("Status:", character.status)
            CharacterDetailRow("Gender:", character.gender)
            CharacterDetailRow("Origin:", character.origin.name)
            CharacterDetailRow("Location:", character.location.name)
            CharacterDetailRow("Episodes:", character.episode.size.toString())
            CharacterDetailRow("Created:", character.created)
        }
    }
}

@Composable
fun CharacterDetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}