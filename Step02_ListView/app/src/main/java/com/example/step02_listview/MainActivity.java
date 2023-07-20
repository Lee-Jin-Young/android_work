package com.example.step02_listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // ListView에 출력할 SampleData
        List<String> names = new ArrayList<>();
        names.add("고가현");
        names.add("김수정");
        names.add("이슬아");
        names.add("최유진");
        for(int i = 0; i<100; i++) {
            names.add("아무개"+i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String msg = names.get(i);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            new AlertDialog.Builder(this)
                    .setTitle("알림")
                    .setMessage("Long Click")
                    .setNeutralButton("확인", null)
                    .create()
                    .show();

            return false;
        });
    }
}