package com.example.hellokotlin

interface Remocon {
    fun up()
    fun down()
}

class MyRemocon : Remocon {
    override fun up() {
        println("MyRemocon up")
    }

    override fun down() {
        println("MyRemocon down")
    }

}

fun main() {
    val r1 = MyRemocon()
    r1.up()
    r1.down()

    val r2 : Remocon = object : Remocon{
        override fun up() {
            println("up")
        }
        override fun down() {
            println("down")
        }
    }

    r2.up()
    r2.down()
}