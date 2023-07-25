package com.example.step04_gallery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends BaseAdapter {
    private LayoutInflater inflater; //레이아웃 전개자 객체
    private Context context; // 앱 context
    private int layoutRes; //셀의 레이아웃 리소스 id
    private List<GalleryDto> list; //모델

    public GalleryAdapter(Context context, int layoutRes, List<GalleryDto> list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getNum();
    }

    //i번째 cell의 view를 만들거나 수정해서 return
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflater.inflate(layoutRes, viewGroup, false);
        }
        // position에 해당하는 GalleryDto
        GalleryDto dto=list.get(position);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textWriter = convertView.findViewById(R.id.writer);
        TextView textCaption = convertView.findViewById(R.id.caption);
        TextView textRegdate = convertView.findViewById(R.id.regdate);

        //작성자, 제목, 등록일 출력
        textWriter.setText(dto.getWriter());
        textCaption.setText(dto.getCaption());
        textRegdate.setText(dto.getRegdate());

        //글라이드 이용하여 이미지 출력
        Glide.with(context)
                .load("http://192.168.0.88:9000/boot07"+dto.getImagePath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);

        return convertView;
    }
}
