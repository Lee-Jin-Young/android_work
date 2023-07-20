package com.example.step01_example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this);

        Button sendBtn2 = findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(view -> {
            EditText editText = findViewById(R.id.editText);
            String msg = editText.getText().toString();
            TextView textView = findViewById(R.id.textView);
            textView.setText(msg);
        });
    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.editText);
        String msg = editText.getText().toString();
        TextView textView = findViewById(R.id.textView);
        textView.setText(msg);
    }
}