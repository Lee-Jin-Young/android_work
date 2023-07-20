package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/*
    MainActivity는 hello2앱이 활성화(luanch)될 때 최초로 사용자를 대면하는 액티비티
    대체로 액티비티 하나는 화면 하나이다.
 */
public class MainActivity extends AppCompatActivity {

    //액티비티가 활성화 될 때 최초 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml을 통해 화면구성
        setContentView(R.layout.activity_main);
    }

    //버튼을 클릭했을 때 호출되는 메소드
    public void clicked(View v) {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
    }

    public void deleteClicked(View v) {
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
    }
}