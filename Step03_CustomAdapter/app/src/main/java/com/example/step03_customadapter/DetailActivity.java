package com.example.step03_customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        CountryDto dto = (CountryDto) intent.getSerializableExtra("dto");

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getContent());

        Button confirmBtn = findViewById(R.id.button);
        confirmBtn.setOnClickListener(view -> {
           finish();
        });
    }
}