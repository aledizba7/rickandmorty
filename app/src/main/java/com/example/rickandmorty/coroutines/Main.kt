package com.example.rickandmorty.coroutines


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
            println("Mi super aplicación")
            val data = consultaBaseDeDatos()
            println(data)
        }
    }
}

fun cAsync(){
    runBlocking {
        val result = async {
            println("Consultando datos")
            delay(3000)
            20 // regresará un 20, oara consultar el resultado se guarda en variable
        }
        println(result.await())
    }
}

suspend fun consultaBaseDeDatos() : String{
    println("Consultando base de datos...")
    delay(2000)
    return "Datos traídos"
}
