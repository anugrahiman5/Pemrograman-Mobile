package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMove, btnMoveWithData, btnCall, btnWeb, btnEks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = findViewById(R.id.btn_move_activity);
        btnMove.setOnClickListener(this);

        btnMoveWithData = findViewById(R.id.btn_move_activity_data);
        btnMoveWithData.setOnClickListener(this);

        btnCall = findViewById(R.id.btn_call);
        btnCall.setOnClickListener(this);

        btnWeb = findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(this);

        btnEks = findViewById(R.id.btn_intent);
        btnEks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveActivity = new Intent(this, MoveActivity.class);
                startActivity(moveActivity);
                break;
            case R.id.btn_move_activity_data:
                Intent moveActivityWithData = new Intent(this, MoveActivityWithData.class);
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_NAME,"Anugrah Iman");
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_AGE,19);
                startActivity(moveActivityWithData);
                break;
            case R.id.btn_call:
                String nomer = "081226388577";
                Intent Call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+nomer));
                startActivity(Call);
                break;
            case R.id.btn_web:
                String link = "https://igracias.ittelkom-pwt.ac.id/";
                Intent web = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
                startActivity(web);
                break;
            case R.id.btn_intent:
                Intent intent = new Intent(this, ExplicitActivity.class);
                startActivity(intent);
        }
    }
}
