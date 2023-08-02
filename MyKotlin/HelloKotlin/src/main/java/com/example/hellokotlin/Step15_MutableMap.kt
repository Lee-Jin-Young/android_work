package com.example.hellokotlin

fun main() {
    //수정 가능 한 맵
    val member = mutableMapOf<String, Any>()
    member.put("num", 1)
    member.put("name", "Lee")
    member.put("isMan", false)

    val member2 = mutableMapOf<String, Any>()
    member2["num"] = 2
    member2["name"] = "kim"
    member2["isMan"] = false
}