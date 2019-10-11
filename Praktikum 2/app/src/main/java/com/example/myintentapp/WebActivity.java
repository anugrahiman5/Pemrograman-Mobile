package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    WebView webittp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webittp = findViewById(R.id.webview);
        WebSettings webSettings = webittp.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webittp.loadUrl("https://ittelkom-pwt.ac.id/");
    }
}
