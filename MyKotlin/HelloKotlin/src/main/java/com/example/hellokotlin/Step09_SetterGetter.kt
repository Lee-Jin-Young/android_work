package com.example.hellokotlin

class StarBucks {
    var location:String? = null
        set(value) {
            //field는 location을 가리키며 value는 넣을 값을 가리킨다.
            field = value+" 지점"
        }
        get() {
            if(field == null) {
                return "지점 명 없음"
            } else {
                return field
            }
        }
}

fun main() {
    val s1 = StarBucks()
    s1.location = "강남"
    println(s1.location)

    val s2 = StarBucks()
    println(s2.location)
}