package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class movedEksplisitActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "Kosong";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moved_eksplisit);

        TextView tvData = findViewById(R.id.tv_KirimData);

        tvData.setText(getIntent().getStringExtra(EXTRA_DATA));
    }
}
