package com.example.step06sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            //프레그먼트 매니저 객체를 이용해서 SettingsFragment 객체로 화면 구성하기
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Context의 참조값을 전달해서 기본(default) SharedPreferences 객체의 참조값
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        // 리스너 등록
        pref.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        SharedPreferences pref = sharedPreferences;
        if(key.equals("signature")){
            //바뀐 value 값 읽어오기
            String value = pref.getString(key, "");
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        } else if (key.equals("reply")) {
            //바뀐 value 값 읽어오기
            String value = pref.getString(key, "");
            Toast.makeText(this, "동기화여부:"+value, Toast.LENGTH_SHORT).show();
        } else if (key.equals("sync")) {
            //바뀐 value 값 읽어오기
            boolean value = pref.getBoolean(key, false);
            Toast.makeText(this, "동기화여부:"+value, Toast.LENGTH_SHORT).show();
        }
    }
    /*
        Setting 정보를 사용자가 변경을 하면 변경된 내용을 자동으로 저장하고
        불러오는 역할을 해주는 프레그먼트 객체
     */
    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}