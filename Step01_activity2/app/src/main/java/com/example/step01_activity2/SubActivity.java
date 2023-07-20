package com.example.step01_activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.d("subActivity", "onCreate() 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("subActivity", "onStart() 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("subActivity", "onResume() 호출");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("subActivity", "onRestart() 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("subActivity", "onPause() 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("subActivity", "onStop() 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("subActivity", "onDestroy() 호출");
    }
}