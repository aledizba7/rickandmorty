package com.example.rickandmorty.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmorty.models.Character
import com.example.rickandmorty.models.Location
import com.example.rickandmorty.models.Origin
import com.example.rickandmorty.services.CharacterService
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun CharacterDetailScreen(id:Int, innerPaddingValues: PaddingValues){
    val scope = rememberCoroutineScope()

    var isLoading by remember{
        mutableStateOf(false)
    }


    var character by remember {
        mutableStateOf(
            Character(
                id = 0,
                name = "",
                status = "",
                species = "",
                gender = "",
                type = "",
                location = Location(name = "", url = ""),
                origin = Origin(name = "", url = ""),
                episode = emptyList(), // Corrected line
                created = "",
                image = "",
                url = ""
            )
        )
    }

    // launched effect ejecuta el código la primera vez
    LaunchedEffect(key1 = id) { // Fetch character details when characterId changes
        scope.launch {
            try {
                isLoading = true
                val BASE_URL = "https://rickandmortyapi.com/api/"
                val characterService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CharacterService::class.java)

                character = characterService.getCharacterById(id)
                isLoading= false
            } catch (e: Exception) {
                Log.e("CharacterDetailScreen", "Error fetching character details: ${e.message}")
                isLoading = false
            }
        }
    }

    if (isLoading) {
        // Display loading indicator
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            CircularProgressIndicator()
        }
    } else if (character != null) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = character!!.image,
                contentDescription = character!!.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Nombre: ${character!!.name}", fontWeight = FontWeight.Bold)
            Text(text = "Estado: ${character!!.status}")
            Text(text = "Especie: ${character!!.species}")
            Text(text = "Género: ${character!!.gender}")
            Text(text = "Ubicación: ${character!!.location.name}")
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CharacterDetailScreenPreview(){
    RickAndMortyTheme {
        CharacterDetailScreen(id = 1, innerPaddingValues = PaddingValues(0.dp))
    }
}