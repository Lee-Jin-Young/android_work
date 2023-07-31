package com.example.step07_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends BaseAdapter {
    //필요한 필드 선언
    Context context;
    int layoutRes;
    List<Todo> list;
    //생성자
    public TodoAdapter(Context context, int layoutRes, List<Todo> list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
    }
    //모델의 갯수
    @Override
    public int getCount() {
        return list.size();
    }
    //i번째 인덱스에 해당하는 모델
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }
    //i 번째 인덱스에 해당하은 모델의 아이디(pk)
    @Override
    public long getItemId(int i) {
        return list.get(i).getNum();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view= LayoutInflater.from(context)
                    .inflate(R.layout.listview_cell, viewGroup, false);
        }

        Todo tmp=list.get(i);
        TextView content=view.findViewById(R.id.text_content);
        TextView regdate=view.findViewById(R.id.text_regdate);
        content.setText(tmp.getContent());
        regdate.setText(tmp.getRegdate());

        return view;
    }
}