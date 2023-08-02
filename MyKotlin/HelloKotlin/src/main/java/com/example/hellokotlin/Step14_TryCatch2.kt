package com.example.hellokotlin

import java.lang.NumberFormatException

fun main() {
    var str = "1000"
    var str2 = "천"

    var result2 = try {
        Integer.parseInt(str)
    } catch(nfe : NumberFormatException) {
        0
    }

    println("result2 : $result2")
}