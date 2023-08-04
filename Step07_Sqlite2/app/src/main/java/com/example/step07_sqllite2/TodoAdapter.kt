package com.example.step07_sqllite2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//대표 생성자 정의
class TodoAdapter constructor(var context:Context, var layoutRes:Int , var list:List<Todo>) : BaseAdapter() {

    //전체 모델의 개수 리턴
    override fun getCount(): Int {
        return list.size
    }

    //i번째 인덱스의 모델 리턴
    override fun getItem(i: Int): Any {
        //return list[i]와 동일
        return list.get(i)
    }

    //i번째 인덱스의 PK값
    override fun getItemId(i: Int): Long {
        return list.get(i).num as Long
    }

    //코틀린의 매개 변수는 기본값이 val, 상수이므로 재할당이 불가능하다.
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        // view가 null인경우 새로운 변수에 값을 담아 그 변수를 return
        var resultView: View = if(view == null) {
            LayoutInflater.from(context).inflate(layoutRes, viewGroup,false)
        }
        // view가 null이 아닌 경우 그대로 view 리턴
        else {
            view
        }

        //position에 해당하는 Todo객체를 얻어와서 할일 정보를 출력
        val tmp = list[position]
        val text_content = resultView.findViewById<TextView>(R.id.text_content)
        text_content.text = tmp.content
        //위의 작업을 apply 를 이용하면 아래 처럼 처리 할수도 있다.
        resultView.findViewById<TextView>(R.id.text_regdate).apply {
            text = tmp.regdate
        }

        return resultView
    }

}

