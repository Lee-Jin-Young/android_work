package com.example.step04_example;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/*
    문자열을 입력하고 "전송" 버튼을 누르면  Util 클래스를 이용해서 GET 방식으로 http://(IPv4주소):9000/boot07/에 요청을 하는 예제
    요청 파라미터는 msg 라는 파라미터 명으로 입력한 문자열이 전송되도록 한다.
    서버가 응답하는 문자열은 EditText 에 출력
 */
public class MainActivity extends AppCompatActivity implements Util.RequestListener{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // activity_main.xml 문서에 정의된 객체의 참조값 얻어오기
        editText = (EditText)findViewById(R.id.editText);
        EditText inputMsg = (EditText)findViewById(R.id.inputMsg);
        Button sendBtn = (Button)findViewById(R.id.sendBtn);

        // 버튼에 리스너 등록
        sendBtn.setOnClickListener(view -> {
            String msg=inputMsg.getText().toString();
            //요청 파라미터로 전달하기 위해 Map에 담는다.
            Map<String, String> map = new HashMap<>();
            map.put("msg", msg);
            //Util 을 이용해서 http 요청
            Util.sendGetRequest(
                    0,
                    "http://192.168.0.88:9000/boot07/android/tweet",
                    map,
                    this
            );
        });

        //두번째 버튼 리스너 등록
        Button sendBtn2 = (Button)findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(view -> {
            //입력한 문자열
            String msg = inputMsg.getText().toString();
            //요청 파라미터로 전달하기 위해 "msg" 라는 키값으로 Map 에 담는다.
            Map<String, String> map = new HashMap<>();
            map.put("msg", msg);
            Util.sendPostRequest(
                    1,
                    "http://192.168.0.88:9000/boot07/android/tweet2",
                    map,
                    this
            );
        });

        //세번째 버튼 리스너 등록
        Button sendBtn3 = (Button)findViewById(R.id.sendBtn3);
        sendBtn3.setOnClickListener(view -> {
            //입력한 문자열
            String msg = inputMsg.getText().toString();
            //요청 파라미터로 전달하기 위해 "msg" 라는 키값으로 Map 에 담는다.
            Map<String, String> map = new HashMap<>();
            map.put("msg", msg);
            Log.d("sendBtn3", "onCreate msg : "+msg);
            Log.d("sendBtn3", "onCreate map : "+map);
            Util.sendPostRequest(
                    2,
                    "http://192.168.0.88:9000/boot07/android/tweet3",
                    map,
                    this
            );
        });

        Button listBtn = findViewById(R.id.listBtn);
        listBtn.setOnClickListener(view -> {
            Util.sendGetRequest(
                    3,
                    "http://192.168.0.88:9000/boot07/android/list",
                    null,
                    this
            );
        });
    }

    @Override
    public void onSuccess(int requestId, Map<String, Object> result) {
        if(requestId == 0) {
            //서버가 응답한 문자열
            String data = (String)result.get("data");
            editText.setText(data);
        }else if(requestId == 1) {
            //json문자열 data
            //editText.setText(data);
            String data = (String)result.get("data");

            //{"isSuccess":true} 형식의 json 문자열은 JSONObject 객체를 이용해서 원하는 데이터를 추출할수 있다.
            try {
                //JSONObject 를 생성해서
                JSONObject obj = new JSONObject(data);
                //"isSuccess" 라는 키값으로 저장된  true 라는 boolean type 데이터 얻어내기
                boolean isSuccess = obj.getBoolean("isSuccess");
                editText.setText(Boolean.toString(isSuccess));

            } catch (JSONException e) {
                //data 가 json 형식에 어긋나면 예외가 발생한다.
                editText.setText(e.getMessage());
            }
        } else if (requestId == 2) {
            String data = (String)result.get("data");
            Log.d("requestId : 2", "data : " + data);
            //data 는 [] 형식의 json 문자열이다.  [] 형식의 json 문자열은 JSONArray 객체를 활용한다.
            try {
                JSONArray arr = new JSONArray(data);
                for(int i = 0; i<arr.length(); i++) {
                    String tmp = arr.getString(i);
                    editText.append(tmp+"\n");
                }
            } catch (JSONException e) {
                //data 가 json 형식에 어긋나면 예외가 발생한다.
                editText.setText(e.getMessage());
            }
        } else if(requestId == 3) {
            String data = (String)result.get("data");
            try {
                JSONArray arr = new JSONArray(data);
                for(int i = 0; i<arr.length(); i++) {
                    // {"num":n, "writer":"xxx", "title":"xxx..."}
                    JSONObject obj = arr.getJSONObject(i);

                    int num = obj.getInt("num");
                    String writer = obj.getString("writer");
                    String title = obj.getString("title");

                    editText.append(num+" | "+writer+" | "+title+"\n");
                }
            } catch(JSONException e) {
                editText.setText(e.getMessage());
            }
        }
    }

    @Override
    public void onFail(int requestId, Map<String, Object> result) {
        if(requestId == 0){
            String data=(String)result.get("data");
            editText.setText(data);
        }
    }
}