package com.example.hellokotlin

class Util {
    companion object {
        val version : String = "1.0"
        fun send() {
            println("전송")
        }
    }
}

fun main() {
    Util.send()
    println(Util.version)
}