package com.example.step05_fragment2;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.step05_fragment2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

/*
    view binding 사용하는 방법

    1. build.gradle 파일에 설정(아래의 문자열을 추가)

    buildFeatures {
        viewBinding = true
    }

    2. build.gradle 파일의 우상단에 sync now 버튼을 눌러서 실제 반영되도록 한다.

    3. layout xml 문서의 이름을 확인해서 자동으로 만들어진 클래스명을 예측한다.

    예를들어  activity_main.xml  문서이면  ActivityMainBinding 클래스
    예를들어  activity_sub.xml 문서이면 ActivitySubBinding 클래스 ...
 */
public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activity_main.xml문서가 존재하기 때문에 ActivityMainBinding클래스가 만들어진다.
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //바인딩객체의 getRoot()메소드가 view객체를 리턴
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar); //setContentView(findViewById(R.id.toolbar));

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //id가 fab인 UI에 클릭이벤트 리스너 등록
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }
    //우상단의 옵션메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // res/menu/menu_main.xml문서를 활용하여 메뉴 아이템 구성하기
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // 좌상단 up버튼 동작
    // up버튼은 계층구조상 상위 계층으로 이동, back버튼은 history상 이전 화면으로 이동
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}