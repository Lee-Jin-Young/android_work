package com.example.hellokotlin

fun main() {
    //수정 불가능한 Map
    val member:Map<String, Any> = mapOf<String, Any>("num" to 1, "name" to "Lee", "isMan" to false)

    //Map에 저장 된 데이터 참조 하는 방법
    val num = member.get("num")
    val name = member.get("name")
    val isMan = member.get("isMen")

    //Map에 저장 된 데이터 참조 하는 방법2
    val num2 = member["num"]
    val name2 = member["name"]
    val isMan2 = member["isMen"]

    //데이터 type
    val num3:Any? = member.get("num")
    val num4:Int = member.get("num") as Int //Int type으로 캐스팅
}