package com.example.hellokotlin

class Gun {
    fun prepare() {
        println("prepared")
    }
    fun fire() {
        println("fired")
    }
    fun end() {
        println("end")
    }
}

class Dialog {
    fun setTitle(title:String) {}
    fun setContent(content:String){}
    fun create(){}
}

fun main() {
    val g1 = Gun()
    g1.prepare()
    g1.fire()
    g1.fire()
    g1.fire()
    g1.end()

    println("==========")

    //with구문을 통해 한 객체의 참조값을 묶을 수 있다.
    with(g1) {
        prepare()
        fire()
        fire()
        fire()
        end()
    }

    val d1 = Dialog()
    with(d1) {
        setTitle("제목")
        setContent("내용")
        create()
    }

    //객체 생성과 동시에 작업이 이루어 진 후 참조값을 대입
    val d2 = Dialog().apply {
        setTitle("제목")
        setContent("내용")
        create()
    }
}