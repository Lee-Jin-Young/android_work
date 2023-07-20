package com.example.step01_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View v) {
        count++;

        TextView a = findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }

    // 리셋 버튼을 클릭
    public void resetClicked(View v){
        count=0;
        /*
            현재활성화 되어있는 액티비티가 구성한 화면에서
            textView 라는 아이디를 가지고 있는 UI 의 참조값 얻
            TextView type 의 a 라는 지역 변수에 담기
         */
        TextView a=findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }
}