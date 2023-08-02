package com.example.hellokotlin

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    print("100~0 사이의 점수 입력 : " )
    val score = scan.nextInt()

    /*
    String grade = " ";
    switch(score/10) {
        case 6 : grade = "D"; break;
        case 7 : grade = "C"; break;
        case 8 : grade = "B"; break;
        case 9 : grade = "A"; break;
        case 10 : grade = "A"; break;
        default : grade = "F"; break;
    }
     */

    val grade:String = when(score) {
        in 90..100 -> "A"
        in 80..89 ->  "B"
        in 70 until 80 -> "C"
        in 60 until 70 -> "D"
        else -> "F"
    }
    println("$score 점으로 학점은 $grade")
}