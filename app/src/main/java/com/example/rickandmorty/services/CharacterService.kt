package com.example.rickandmorty.services

import com.example.rickandmorty.models.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("character")
    suspend fun getCharacters(): List<Character>

    // los query y los path se diferencian con el /{} y otras cosas
    @GET("character/{id}")
    suspend fun getProductById(@Path("id") id:Int) : Character

}
