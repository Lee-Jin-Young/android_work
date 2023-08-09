package com.example.hellokotlin

class Human {
    val name:String
    //String type 을 전달 받는 생성자
    constructor(name:String) {
        this.name = name
    }
}
//위의 클래스를 아래와 같은 형태로도 정의 할수 있다.
class Human2 constructor(name:String) {
    val name:String
    init {
        this.name = name
    }
}
//위의 작업을 줄여서 쓰면 아래와 같다
class Human3 constructor(val name:String) {
}
//위의 작업을 조금더 줄여서 쓰면 아래와 같다
class Human4(val name:String)

//참조값을 출력했을때 필드안에 들어 있는 내용을 확인 가능 하게 하려면 data 키워드를 이용해서 클래스를 정의하면 된다.
data class Human5(val name:String)

fun main() {
    val h1 = Human("Kim")
    val h2 = Human2("Lee")
    val h3 = Human3("Park")
    val h4 = Human4("Ko")
    val h5 = Human5("Song")

    println("h4 : $h4")
    println("h5 : $h5")
}