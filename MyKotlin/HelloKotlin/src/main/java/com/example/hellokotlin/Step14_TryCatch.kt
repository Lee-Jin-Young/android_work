package com.example.hellokotlin

import java.lang.NumberFormatException
import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    print("숫자 입력 : ")
    try {
        val result:String = scan.nextLine()
        val num = Integer.parseInt(result)

        if(num%2==0) println("$num 은 짝수") else println("$num 은 홀수")
    } catch (nfe:NumberFormatException) {
        println("숫자 형태로 입력")
    }
}