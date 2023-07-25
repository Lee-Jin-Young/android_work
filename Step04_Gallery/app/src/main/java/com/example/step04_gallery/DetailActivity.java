package com.example.step04_gallery;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.step04_gallery.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView writer = findViewById(R.id.writer);
        TextView caption = findViewById(R.id.caption);
        TextView regdate = findViewById(R.id.regdate);

        Intent intent = getIntent();
        GalleryDto dto = (GalleryDto)intent.getSerializableExtra("dto");
        writer.setText(dto.getWriter());
        caption.setText(dto.getCaption());
        regdate.setText(dto.getRegdate());

        Glide.with(this)
                .load(AppConstants.BASE_URL+dto.getImagePath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}