package com.example.hellokotlin

abstract class Weapon {
    fun move() {
        println("이동합니다.")
    }
    abstract fun attack()
}

class MyWeapon : Weapon() {
    override fun attack() {
        println("공격합니다.")
    }
}

fun main() {
    val w1 = MyWeapon()
    w1.move()
    w1.attack()

    println("=====")

    val w2 = object : Weapon() {
        override fun attack() {
            println("다른 공격")
        }
    }
    w2.move()
    w2.attack()

    println("=====")

    /*
        with(참조값) {
            메소드들
        }
     */
    with(w2) {
        move()
        attack()
    }

    val w3 = MyWeapon()

    val a : MyWeapon = w3 //w3은 MyWeapon type
    val b : Weapon = w3 //w3은 Weapon type 이기도 함
    val c : Any = w3 //Any type은 어떤 타입의 변수도 담을 수 있음(java의 object타입과 같다)

    var d : Any = 10
    d = true
    d = "lee"
    d = w3
}