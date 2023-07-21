package com.example.step03_customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public List<CountryDto> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = new ArrayList<>();
        countries.add(new CountryDto(R.drawable.austria, "오스트리아", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.belgium, "벨기에", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.brazil, "브라질", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.france, "프랑스", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.germany,"독일", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.greece, "그리스", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.israel, "이스라엘", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.italy, "이탈리아", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.japan, "일본", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.korea, "대한민국", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.poland, "폴란드", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.spain, "스페인", "다람쥐 헌 쳇바퀴에 타고파"));
        countries.add(new CountryDto(R.drawable.usa, "미국", "다람쥐 헌 쳇바퀴에 타고파"));

        CountryAdapter adapter = new CountryAdapter(this,R.layout.listview_cell, countries);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
        Intent intent = new Intent(this, DetailActivity.class);

        CountryDto dto = countries.get(i); //터치한 셀의 나라정보
        intent.putExtra("dto", dto);

        startActivity(intent);
    }
}