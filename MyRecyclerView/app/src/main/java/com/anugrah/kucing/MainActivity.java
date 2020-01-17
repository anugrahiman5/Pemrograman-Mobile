package com.anugrah.kucing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHmj;
    private ArrayList<Kucing> list = new ArrayList<>();
    private Menu menu;
    private ViewFlipper v_flip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.kucing1, R.drawable.kucing2, R.drawable.kucing3};
        v_flip = findViewById(R.id.v_flip);

        for (int i = 0; i <images.length ; i++) {
            flipImages(images[i]);
        }
        for(int image: images)
            flipImages(image);

        rvHmj = findViewById(R.id.rv_hmj);
        rvHmj.setHasFixedSize(true);

        list.addAll(KucingData.getListData());
        showRecyclerList();
    }
    public void flipImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flip.addView(imageView);
        v_flip.setFlipInterval(4000);
        v_flip.setAutoStart(true);

        v_flip.setInAnimation(this, android.R.anim.slide_in_left);
        v_flip.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    private void showRecyclerList() {
        rvHmj.setLayoutManager(new LinearLayoutManager(this));
        CardKucingAdapter cardKucingAdapter = new CardKucingAdapter(list, this);
        rvHmj.setAdapter(cardKucingAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_item, menu);
        invalidateOptionsMenu();
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_about){
            Intent about = new Intent(this, About.class);
            startActivity(about);
        }
        return super.onOptionsItemSelected(item);
    }
}
