package com.example.rickandmorty.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    cAsync()
}

fun cLaunch(){
    runBlocking {
        launch {
            println("API de Rick and Morty")
            val data = consultaBaseDeDatos()
            println(data)
        }
    }
}

fun cAsync(){
    runBlocking {
        val result = async {
            println("Buscando personajes yupii")
            delay(3000)
            20
        }
        println(result.await())
    }
}

suspend fun consultaBaseDeDatos() : String{
    println("Extrayendo base de datos...")
    delay(2000)
    return "Datos extraídos!"
}

