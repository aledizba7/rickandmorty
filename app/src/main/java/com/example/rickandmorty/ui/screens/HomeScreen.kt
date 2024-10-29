package com.example.rickandmorty.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.rickandmorty.composables.CharacterCard
import com.example.rickandmorty.models.Result
import com.example.rickandmorty.services.CharacterService
import com.example.rickandmorty.ui.components.ApiTemplate
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController) {
    val scope = rememberCoroutineScope()
    var characters by remember { mutableStateOf(listOf<Result>()) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {

        scope.launch {
            try {

                isLoading = true

                val BASE_URL = "https://rickandmortyapi.com/api/"

                val characterService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CharacterService::class.java)

                val response = characterService.getCharacters(1)
                characters = response.results
                Log.i("HomeScreenResponse", characters.toString())
                isLoading = false

            } catch (e: Exception) {

                characters = listOf()
                isLoading = false

            }
        }
    }

    ApiTemplate(innerPadding = innerPadding,
        header = { }) {

        if (isLoading) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                items(characters) { character ->
                    CharacterCard(character, navController)
                }
            }
        }

    }
}
