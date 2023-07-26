package com.example.hellokotlin

/*
    [ kotlin 기본 data type ]
    - import 없이 바로 사용할수 있는 data type

    Byte, Short, Int, Long
    Float, Double
    Boolean, Char
    String
 */


fun main() {
    var num : Int = 10
    var num2 : Double = 10.1
    var myName : String = "young"

    //val은 한번 정의 된 후 값을 변경할 수 없다.
    val yourName : String = " String"
    //myName = "hello"
    //myName = "안녕"

    //type추론이 가능한 경우 type 생략 간으
    var num3 = 30
    var ourName = "Acorn"
    var num4 = 10.1

    //선언만 하고 나중에 정의 가능
    var num5 : Int
    num5 = 50
    //단, 선언 시 반드시 type이 있어야함
    //var num6
    var num6 : Int
    num6 = 60
    val PI : Float
    PI = 3.14f

}