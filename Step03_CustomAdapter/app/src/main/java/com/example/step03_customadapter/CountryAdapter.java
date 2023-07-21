package com.example.step03_customadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*
    listView에 연결할 어댑터 클래스 정의하기
 */
public class CountryAdapter extends BaseAdapter {
    //필드
    Context context;
    int layoutRes;
    List<CountryDto> list;

    //생성자
    public CountryAdapter(Context context, int layoutRes, List<CountryDto> list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
    }

    //모델의 개수 리턴
    @Override
    public int getCount() {
        return list.size();
    }

    //i번째 인덱스에 해당하는 모델 리턴
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    //i번째 인덱스에 해당하는 모델의 아이디(primary key)가 있다면 리턴
    @Override
    public long getItemId(int i) {
        return i;
    }

    //i번째 인덱스에 해당하는 cell view를 리턴
    /*
        인자로 전달 되는 i번째 cell view를 만들어서 리턴
        cell view는 레이아웃의 cml문서를 전개하여 만든다.
        만들어진 view에 적절한 데이터를 출력하여 view객체를 리턴
        cell view는 최소한으로 만들어 재사용한다.
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("CountryAdapter", i+"번째 getView() 호출됨");
        if (view == null) {
            Log.d("CountryAdapter", i+"번째 view가 null값을 가지기 때문에 cell view를 만든다.");
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layoutRes, viewGroup, false);
        }

        CountryDto dto = list.get(i);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getName());

        return view;
    }
}
