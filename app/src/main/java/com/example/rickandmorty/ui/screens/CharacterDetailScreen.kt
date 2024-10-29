package com.example.rickandmorty.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.composables.CharacterDetailCard
import com.example.rickandmorty.composables.CharacterImageCard
import com.example.rickandmorty.models.Result
import com.example.rickandmorty.services.CharacterService
import com.example.rickandmorty.ui.components.ApiTemplate
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun CharacterDetailScreen(id: Int, innerPaddingValues: PaddingValues) {
    val scope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var character by remember { mutableStateOf<Result?>(null) }

    LaunchedEffect(key1 = id) {
        scope.launch {
            val BASE_URL = "https://rickandmortyapi.com/api/"
            val characterService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CharacterService::class.java)

            isLoading = true
            character = characterService.getCharacterById(id)
            isLoading = false
        }
    }

    ApiTemplate(innerPadding = innerPaddingValues, header = {  }) {
        if (isLoading) {
            Box(
                modifier = Modifier
                    .padding(innerPaddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            character?.let { character ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPaddingValues)
                        .fillMaxSize()
                ) {
                    item {
                        CharacterImageCard(character.image, character.name)
                    }
                    item {
                        CharacterDetailCard(character)
                    }
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProductDetailScreenPreview(){
    RickAndMortyTheme {
        CharacterDetailScreen(id = 1, innerPaddingValues = PaddingValues(0.dp))
    }
}