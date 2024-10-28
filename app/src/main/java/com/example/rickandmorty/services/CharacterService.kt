package com.example.rickandmorty.services

import com.example.rickandmorty.models.Character
import com.example.rickandmorty.models.Result
import retrofit2.http.GET
import retrofit2.http.Path

// la interfaz es un contrato que una clase debe seguir, la necesitamos porque retrofit hace toda la API
// pero nosotros ocupamos definirselo

interface CharacterService {

    @GET("characters")
    suspend fun getCharacters() : Result

    @GET("characters/{id}")
    suspend fun getCharacterById(@Path("id") id:Int) : Character

}