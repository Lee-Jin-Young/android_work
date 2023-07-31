package com.example.hellokotlin
/*
    kotlin은 상속을 받지 못하는것이 기본값으로 되어있다.
    상속을 받을 수 있게 하려면 open을 사용한다.
 */
open class Phone {
    fun call() {
        println("call")
    }
}

open class HandPhone : Phone() {
    fun mobileCall() {
        println("mobileCall")
    }
    open fun takePicture() {
        println("takePicture")
    }
}

class SmartPhone : HandPhone() {
    fun doInternet() {
        println("doInternet")
    }
    override fun takePicture() {
        super.takePicture()
        println("takePicture SmartPhone")
    }
}

fun main() {
    val p1 = Phone()
    var p2 = HandPhone()

    p1.call()

    println("=====")

    p2.call()
    p2.mobileCall()
    p2.takePicture()

    val p3=SmartPhone()
    p3.doInternet()
    p3.takePicture()
}