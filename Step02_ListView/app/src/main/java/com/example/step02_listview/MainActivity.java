package com.example.step02_listview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
        for(int i = 0; i<30; i++) {
            names.add("이름"+i);
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
            /*
            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int result) {
                    //긍정버튼을 눌렀을 때
                    if(result == DialogInterface.BUTTON_POSITIVE) {
                        names.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                }
            };
            */

            new AlertDialog.Builder(this)
                    .setTitle("알림")
                    .setMessage("삭제하시겠습니까?")
                    .setPositiveButton("네", (a, b) -> {

                    })
                    .setNegativeButton("아니요",null)
                    .create()
                    .show();

            return false;
        });

        //addBtn 누르면 editText의 내용을 listView에 추가
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view -> {
            TextView textView = findViewById(R.id.inputName);
            String name = textView.getText().toString();

            names.add(name);
            adapter.notifyDataSetChanged();
            listView.smoothScrollToPosition(adapter.getCount()); //추가 시 추가된 위치(마지막)으로 이동
        });
    }
}