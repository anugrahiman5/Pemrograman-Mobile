package com.anugrah.myclass;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mugiwara.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table biodata(no int primary key, " +
                "nama text null, tgl text null, jk text null, alamat text null);";
        db.execSQL(sql);
        Log.d("Data", "onCreate: " +sql);
        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES('0'," +
                "'Monkey D. Luffy', '1996-05-5', 'Laki-laki', 'Cilacap');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
