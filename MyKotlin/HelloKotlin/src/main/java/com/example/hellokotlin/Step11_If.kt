package com.example.hellokotlin

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    print("숫자 입력 : ")
    val inputNum = scan.nextInt()

    var result:String

    //홀짝 판단
    if(inputNum%2 == 1) {
        result = "$inputNum 은 홀수"
    } else {
        result = "$inputNum 은 짝수"
    }
    /*
        코틀린은 3항연산자가 없다.
        result = inputNum%2==1 ? inputNum+" 은 홀수" : inputNum+" 은 짝수"; 와 같은 형태는 불가능
        아래의 형태로는 사용 가능하다.
    */
    val result2 =
        if(inputNum%2 == 1) {
            "$inputNum 은 홀수"
        } else {
            "$inputNum 은 짝수"
        }
    //if문 블럭 내부에 한줄의 코드만 있을 경우 {중괄호}가 생략 가능한 것을 이용하면 한줄로 작성 가능하다.
    val result3 = if(inputNum%2 == 1) "$inputNum 은 홀수" else "$inputNum 은 짝수"
    //if문 블럭 내부에 여러줄의 코드가 있을 경우 마지막 줄이 return된다.
    val result4 =
        if(inputNum%2 == 1) {
            println("계산중...")
            "$inputNum 은 홀수"
        } else {
            println("계산중...")
            "$inputNum 은 짝수"
        }

    println(result)
    println(result2)
    println(result3)
    println(result4)
}