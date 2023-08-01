package com.example.hellokotlin

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    println("Gun:1, Sword:2")
    print("무기를 선택하세요(1 | 2) ")
    val weapon = scan.nextInt()

    when(weapon) {
        1 -> println("총을 골랐습니다.")
        2 -> println("칼을 골랐습니다.")
        else -> println("1 또는 2를 입력하세요.")
    }
}