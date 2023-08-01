package com.example.hellokotlin

fun main() {
    //수정 불가능한 String 목록 (ReadOnly)
    val names = listOf<String>("Kim", "Lee", "Park")

    //모든 아이템을 순서대로 참조
    for(item in names) {
        println(item)
    }

    println("==========")

    //index를 순서대로 참조
    for(index in names.indices) {
        println("$index 번째 : ${names[index]}")
    }

    println("==========")

    for(num in 1..10) {
        println(num)
    }

    println("==========")

    //1부터 10까지 홀수만 출력
    for(num in 1..10 step 2) {
        println(num)
    }

    println("==========")

    //1부터 10까지 역순으로 출력
    for(num in 10 downTo 1) {
        println(num)
    }

    println("==========")

    //names배열을 역순으로 출력
    for(index in names.size-1 downTo 0) {
        println("$index 번째 : ${names[index]}")
    }
}