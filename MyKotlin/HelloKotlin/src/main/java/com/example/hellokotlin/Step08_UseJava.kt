package com.example.hellokotlin

import com.example.hellokotlin.java.MemberDto
import com.example.hellokotlin.java.Sender
import java.util.Scanner

fun main() {
    val s = Sender()
    s.send("hello")

    val scan = Scanner(System.`in`)
    print("입력 : ")
    val msg = scan.nextLine()
    println("입력받은 내용 : "+msg)

    val mem1 = MemberDto()
    mem1.num = 1
    mem1.name = "lee"
    mem1.addr = "경기"

    val a = mem1.num
    val b = mem1.name
    val c = mem1.addr
}