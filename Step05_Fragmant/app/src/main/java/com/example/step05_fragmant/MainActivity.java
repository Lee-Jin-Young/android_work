package com.example.step05_fragmant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.step05_fragmant.databinding.ActivityMainBinding;
import com.example.step05_fragmant.databinding.FragmentMyBinding;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener {
    //MyFragment에서 전달하는 메세지를 받기 위해 인터페이스 구현

    ActivityMainBinding binding;
    FragmentMyBinding fragBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //view binding 객체
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fm = getSupportFragmentManager();

        MyFragment fragment1 = (MyFragment)fm.findFragmentById(R.id.fragment1);
        MyFragment fragment2 = (MyFragment)fm.findFragmentById(R.id.fragment2);
        binding.resetBtn.setOnClickListener(view -> {
            fragment1.reset();
            fragment2.reset();
        });

        binding.moveBtn.setOnClickListener(view -> {
            Intent loginIntent = new Intent(this, SubActivity.class);
            startActivity(loginIntent);
        });
    }

    @Override
    public void sendMsg(String msg) {
        Toast.makeText(this, "MyFragment : "+msg, Toast.LENGTH_SHORT).show();
    }
}