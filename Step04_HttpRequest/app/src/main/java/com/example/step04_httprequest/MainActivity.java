package com.example.step04_httprequest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        EditText inputUrl=findViewById(R.id.inputUrl);
        //요청 버튼을 클릭했을때 동작할 준비
        Button requestBtn=findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(view -> {
            //1. 입력한 url 주소를 읽어와서
            String url=inputUrl.getText().toString();
            //2. http 요청을 하고
            new RequestTask().execute(url);
        });
    }
    //비동기 Task 객체를 생성할 클래스
    class RequestTask extends AsyncTask<String, Void, String>{

        //백그라운드(새로운 스레드의 run() 메소드) 에서 작업할 내용
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder builder=new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                if(conn != null){
                    Log.d("####", "ok");
                    conn.setConnectTimeout(20000); //응답을 기다리는 최대 대기 시간
                    conn.setRequestMethod("GET");// 요청 메소드 설정 (Default 는 GET)
                    conn.setUseCaches(false);//캐시 사용 여부
                    int responseCode=conn.getResponseCode();
                    Log.d("####", "code:"+responseCode);
                    if(responseCode == HttpURLConnection.HTTP_OK){
                        //문자열을 읽어들일수 있는 객체의 참조값 얻어오기
                        BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while(true){
                            String line=br.readLine();
                            if(line==null)break;
                            builder.append(line);
                        }
                    }
                }
            }catch (Exception e){
                Log.e("RequestTask 클래스", e.getMessage());
            }
            return builder.toString();
        }
        //doInBackground() 메소드에서 리턴된 문자열이 메소드가 호출될 때 인자로 전달
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //여기는 UI 스레드 상에서 동작하는 메소드 이다.
            editText.setText(s);
        }
    }
}







