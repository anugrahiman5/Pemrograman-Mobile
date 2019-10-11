package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEks;
    EditText etEks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        etEks = findViewById(R.id.edit);

        btnEks = findViewById(R.id.btn_move_eksplisit);
        btnEks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_move_eksplisit){
                Intent intent = new Intent(this, movedEksplisitActivity.class);
                intent.putExtra(movedEksplisitActivity.EXTRA_DATA,etEks.getText().toString());
                startActivity(intent);
        }

    }
}
