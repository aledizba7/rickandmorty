package com.example.rickandmorty.models

data class Result(
    val info: Info,
    val results: List<Result>
)