package com.example.hellokotlin

/*
    String type의 편리한 기능
 */

fun main() {
    val myName = "young"
    val yourName = "kim"

    //연결 연산자 가능
    val result = "나의 이름 : "+myName

    //$변수명으로 문자열 연결 가능
    val result2 = "너의 이름 : $yourName"

    //${} 연산 가능
    val result3 = "우리의 이름 : ${myName+yourName}"
    val num1 = 10
    val num2 = 20
    val result4 = "${num1+num2}"

    //여려줄의 문자열을 편리하게 작성 할 수 있다.
    val html = """
        <div>
            <p> p요소 입니다. </p>
        </div>
    """
    val html2 = """
        <div>
            <p> p요소 입니다. </p>
        </div>
    """.trimIndent()

    println(html)
    println("==========")
    println(html2)
}