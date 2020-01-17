package com.anugrah.mylocalization;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_profile, container, false);
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_profile, null);
        TextView tvNama = root.findViewById(R.id.tv_nama);
        TextView tvAlamat = root.findViewById(R.id.tv_alamat);
        TextView tvHobi = root.findViewById(R.id.tv_hobi);
        TextView tvQuote = root.findViewById(R.id.tv_quote);
//        int goal1 = 2;
//        int goal2 = 0;
//        String football = String.format(getResources().getString(R.string.goal),"Lilypali" , "Irfan Bachdim", goal1, goal2);
        tvNama.setText(getResources().getString(R.string.nama));
        tvAlamat.setText(getResources().getString(R.string.alamat));
        tvHobi.setText(getResources().getString(R.string.hobi));
        tvQuote.setText(getResources().getString(R.string.quote));
//        int songCount = 5;
//        String pluralText = getResources().getQuantityString(R.plurals.numberOfSongsAvailable, songCount, songCount);
//        tvPlural.setText(pluralText);
//        tvXliff.setText(getResources().getString(R.string.app_homeurl));
        return root;
    }

}
