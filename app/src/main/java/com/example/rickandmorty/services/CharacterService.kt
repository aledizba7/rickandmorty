package com.example.rickandmorty.services

import com.example.rickandmorty.models.Character
import com.example.rickandmorty.models.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Character

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Result

}
