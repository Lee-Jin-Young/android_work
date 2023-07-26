package com.example.step05_fragmant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/*
    [Fragment 만드는 방법]
    1. Fragment 클래스를 상속받는다.
    2. Fragment의 Layout xml문서를 만든다
    3. onCreateView() 메소드를 오버라이딘 한다.
 */
public class MyFragment extends Fragment implements View.OnClickListener {
    TextView textView;

    //해당 fragment가 제어할 view객체를 만들어서 리턴해주는 메소드
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        textView = view.findViewById(R.id.textView);
        textView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Integer count = Integer.parseInt(textView.getText().toString());
        count++;
        textView.setText(Integer.toString(count));

        /*
            아래와 같은 방식으로 코딩 시 MyFragment는 MainActivity에 의존성이 생기므로 좋지 않은 방식
            MainActivity m = (MainActivity)getActivity();
            m.sendMsg("...");
         */
        FragmentActivity fa = getActivity(); //현재 fragment를 제어하고 있는 액티비티의 참조값
        //MyFragmentListener를 구현하지 않았을 수 있기 때문에 무결성확인이 필요
        if(fa instanceof MyFragmentListener){
            MyFragmentListener fl = (MyFragmentListener)fa;
            fl.sendMsg("hello");
        }
    }

    public void reset() {
        Integer count = Integer.parseInt(textView.getText().toString());
        textView.setText("0");
    }

    public interface MyFragmentListener {
        public void sendMsg(String msg);
    }
}
