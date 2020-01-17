package com.anugrah.kucing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardKucingAdapter extends RecyclerView.Adapter<CardKucingAdapter.ListViewHolder> {

    private ArrayList<Kucing> listKucing;
    private Context context;

    public CardKucingAdapter(ArrayList<Kucing> listKucing, Context context) {
        this.listKucing = listKucing;
        this.context = context;
    }


    @NonNull
    @Override
    public CardKucingAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_card_kucing_adapter, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardKucingAdapter.ListViewHolder holder, int position) {
        final Kucing kucing = listKucing.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kucing.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(kucing.getName());
        holder.tvDesc.setText(kucing.getDesc());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailHmj = new Intent(context, DetailListKucing.class);
                detailHmj.putExtra("hmj_id", kucing.getId());
                context.startActivity(detailHmj);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listKucing.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_hmj_list);
            tvName = itemView.findViewById(R.id.name_hmj_list);
            tvDesc = itemView.findViewById(R.id.desc_hmj_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
