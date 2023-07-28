package com.example.hellokotlin

class Cat constructor() {
    init {
        println("cat생성자")
    }

    // 뒤늦은 초기화가 가능한 필드 lateinit
    lateinit var name:String;

    //this()는 해당 객체의  primary생성자를 호출한다.
    constructor(name:String) : this() {
        println("고양이의 이름은 ${name}")
        this.name = name;
    }
}

class Dog constructor() {
    init {
        println("dog생성자")
    }

    var name: String? = null

    constructor(name: String) : this() {
        // null 이 가능한 type 공간에  null 이 불가능한 type 공간에 담긴 값을 대입하는것은 가능
        this.name = name

    }
}

fun main() {
    Cat("톰캣")

    // 나중에 값을 대입해야하는 변수는 데이터타입에 ?를 붙히면 null값을 넣을 수 있다.
    // kotlin은 기본적으로 null값을 넣을 수 없다.
    var c2 = Cat()
    println(c2.name)
    var catName : String? = null
    catName = "다른고양이"
    catName = null

    //kotlin은 모두 참조데이터 타입이므로 Int?형에도 null값이 들어갈 수 있다.
    var myNum : Int? = null;
}

