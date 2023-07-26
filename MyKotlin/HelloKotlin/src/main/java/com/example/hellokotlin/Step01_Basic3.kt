package com.example.hellokotlin

/*
    Kotlin에서의 배열과 반복문
 */

fun main() {
    //수정 불가능한 목록(List)
    val names : List<String> = listOf("kim", "lee", "park")
    val animals = listOf<String>("dog", "cat")
    val nums = listOf(10, 20, 30)

    //배열의 참조
    println(names[0])
    println(names[1])
    println(names[2])

    //val타입이므로 수정은 불가하다
    //names[0] = "김"

    //indices는 index의 복수형
    val result = names.indices

    println("==========")
    for(i in names.indices) {
        println(names[i])
    }

    println("==========")
    for(i in names.indices) {
        println("$i : ${names[i]}")
    }

    println("==========")
    for(item in names) {
        println(item)
    }

    println("==========")
    names.forEach {
        println(it)
    }
}