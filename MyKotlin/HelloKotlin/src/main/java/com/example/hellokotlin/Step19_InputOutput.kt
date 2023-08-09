package com.example.hellokotlin

import java.io.File
import java.io.FileWriter
import java.util.Scanner

/*
    반복문 3번 돌면서 키보드로 부터 문자열을 각각 3 줄을 입력 받아 c:\acorn202304\myFolder\msgs.txt 파일을 생성해서 입력한 문자열 저장
 */

fun main() {
    val scan = Scanner(System.`in`)
    val list =  mutableListOf<String>()

    for( i in 0..2) {
        print("메세지 입력:")
        val msg = scan.nextLine()
        list.add(msg)
    }

    val f = File("c:/acorn202304/myFolder/msgs.txt")
    //만일 msgs.txt 파일이 없을 경우 새로 만든다.
    if(!f.exists()) {
        f.createNewFile()
    }

    val fw = FileWriter(f, true)

    list.forEach {
        fw.append(it+"\n")
    }

    fw.close()
    println("파일에 문자열을 기록 했습니다.")
}