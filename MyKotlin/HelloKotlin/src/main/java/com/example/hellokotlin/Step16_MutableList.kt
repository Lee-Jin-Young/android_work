package com.example.hellokotlin

/*
    순서가 중요한 데이터를 사용하고, 중간에 수정도 가능하게 하려면 MutableList를 사용한다.
 */

fun main() {
    val names: MutableList<String> = mutableListOf<String>("kim", "lee")
    // type, generic 이 추론 가능하기 때문에 생략 가능
    val names2 = mutableListOf("kim", "lee")
    //mutable은 아이템 추가가 가능하다
    names.add("park")
    names.add("jung")
    names.add("kim")
    //아이템 수정 가능
    names.set(0, "shin")
    names[1] = "ko"
    //아이템 삭제 가능
    names.removeAt(0) //3번 인덱스의 아이템 삭제
    names.removeLast() //마지막 인덱스의 아이템 삭제
    names.forEach {
        println(it)
    }
}