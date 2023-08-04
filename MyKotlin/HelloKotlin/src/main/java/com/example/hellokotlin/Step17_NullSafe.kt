package com.example.hellokotlin
/*
    kotlin 에서는 null 이 가능한 type 과 null 이 불가능 한 type 이 구분 되어 있다.
    null 이 가능한 type data 를 사용할 때는 추가 해야 하는 문법이 있다.
 */

// null 이 가능한 매개 변수가 선언되어 있는 함수
fun send(msg:String?){
    // msg 가 null 이 아니면 length 를 참조해라
    val result=msg?.length
    // msg 는 확실히 null 이 아니야 그냥 length 를 참조해!
    val result2=msg!!.length
}

fun main() {
    var str : String = "abcde12345"
    var str2 : String? = "abcde12345"

    //str = null 은 불가능 하다
    str2 = null //은 가능 하다

    //문자열 의 길이를 안전 하게 참조 가능 (null 값이 아니기 때문)
    val result = str.length
    /*
        참조값이 ?. 일경우 참조값 이 null 이 아닌 경우에 우측의 필드를 참조 하거나 메소드 를 호출 하라는 의미 이다.
     */
    val result2 = str2?.length

    println("result:$result")
    println("result2:$result2")

    var str3:String? = null
    str3="안녕하세요"
    // 컴파일러가 null 이 아닌것을 확실히 인지한다면  ? 생략가능
    val result3 = str3.length

    send("hi")
    //아래는  NullPointerException 발생
    send(null)
}