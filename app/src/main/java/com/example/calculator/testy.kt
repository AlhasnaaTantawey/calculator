package com.example.calculator

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking



    fun main(){
        runBlocking {
            launch {
                delay(3_000)
                println("Hello")
            }
            println("word")
        }
    }
