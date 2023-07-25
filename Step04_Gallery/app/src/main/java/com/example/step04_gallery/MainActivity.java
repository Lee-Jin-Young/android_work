package com.example.step04_gallery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Util.RequestListener {
    List<GalleryDto> list;
    GalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new GalleryAdapter(this, R.layout.listview_cell, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, i, id) -> {
            GalleryDto dto = list.get(i); //클릭한 셀의 dto
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("dto", dto); //intent객체에 serializable type담기
            startActivity(intent); //액티비티 이동
        });

        Util.sendGetRequest(
                0,
                "http://192.168.0.88:9000/boot07/android/gallery/list",
                null,
                this
        );
    }

    @Override
    public void onSuccess(int requestId, Map<String, Object> result) {
        if(requestId==0) {
            String json = (String)result.get("data");
            try {
                JSONArray arr = new JSONArray(json);
                for(int i = 0; i<arr.length(); i++) {
                    JSONObject tmp = arr.getJSONObject(i);
                    GalleryDto dto = new GalleryDto();
                    dto.setNum(tmp.getInt("num"));
                    dto.setWriter(tmp.getString("writer"));
                    dto.setCaption(tmp.getString("caption"));
                    dto.setRegdate(tmp.getString("regdate"));

                    String url = "https://192.168.0.88:9000/boot07/gallery/images/"+tmp.getString("imagePath");
                    dto.setImagePath(tmp.getString("imagePath"));
                    list.add(dto);
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onFail(int requestId, Map<String, Object> result) {

    }
}