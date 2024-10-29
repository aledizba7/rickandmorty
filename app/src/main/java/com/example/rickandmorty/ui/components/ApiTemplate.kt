package com.example.rickandmorty.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ApiTemplate(
    innerPadding: PaddingValues,
    header: @Composable ()->Unit,
    body: @Composable ()->Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Color.DarkGray)
            .verticalScroll(
                rememberScrollState()
            )
    ){
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                .height(200.dp)
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
        ){
            AsyncImage(
                model = "https://static.wikia.nocookie.net/rickandmorty/images/c/c8/Rick_and_Morty_logo.png/revision/latest?cb=20160907114210",
                contentDescription = "Rick and Morty Header Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
            header()
        }


        // Body
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.DarkGray)
                .padding(12.dp)
        ){
            body()
        }
    }
}