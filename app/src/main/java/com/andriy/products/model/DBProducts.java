package com.andriy.products.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBProducts extends SQLiteOpenHelper {

    public DBProducts(Context context) {
        super(context, "DBProducts", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table products (" +
                "id integer primary key, " +
                " name text, " +
                " price integer" +");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists products");

        onCreate(db);
    }
}