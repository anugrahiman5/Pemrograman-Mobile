package com.anugrah.kucing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailListKucing extends AppCompatActivity {

    private  int hmj_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;
    private ArrayList<Kucing> listKucing = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_kucing);

        hmj_id = getIntent().getIntExtra("hmj_id", 0);
        tvName = findViewById(R.id.nama_hmj);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listKucing.addAll(KucingData.getListData());
        getSupportActionBar().setTitle(listKucing.get(hmj_id).getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setLayout();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setLayout() {
        tvName.setText(listKucing.get(hmj_id).getName());
        tvDesc.setText(listKucing.get(hmj_id).getDesc());
        Glide.with(this)
                .load(listKucing.get(hmj_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }
}
