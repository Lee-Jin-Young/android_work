package com.example.hellokotlin

/*
class Person constructor(name:String) {
    //필드 선언
    var name:String
    //초기화 블럭
    init {
        //생성자의 인자로 전달받은 값을 매개 변수에 저장
        this.name=name
    }
}
*/

//위를 줄이면 아래와 같다
//var || val을 생성자의 인자에 선언하면 전달 받은 값과 같은 이름의 필드가 자동으로 생성, 대입된다.
class Person(var name:String)

data class Member(var num:Int, var name:String, var addr:String)

fun main() {
    var p1 = Person("Lee")
    println("p1.name : "+p1.name)
    println(p1)

    println("==========")

    var m1 = Member(1, "Lee", "경기")
    println("번호 : ${m1.num} | 이름 : ${m1.name} | 주소 : ${m1.addr}")
    println(m1)

    val members : MutableList<Member> = mutableListOf()
     //kotlin은 타입추론이 가능하므로 타입 생략 가능
    val members2 = mutableListOf<Member>()

    members.add(m1)
    members.add(Member(2, "kim", "서울"))

    //아래의 두 코드는 동일하게 작동한다.
    println("==========")
    members.forEach(fun(item) {
        println(item)
    })
    println("==========")
    members.forEach{
        println(it)
    }
}