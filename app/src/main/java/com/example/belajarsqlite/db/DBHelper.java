package com.example.belajarsqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String db_name = "inventori.db";
    public static final String TABLE_NAME = "data_inventori";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_BRAND = "brand";
    public static final String COLUMN_PRICE = "price";

    private static final int db_version=1;

    private static final String db_create = "CREATE TABLE "
            +TABLE_NAME+"("
            +COLUMN_ID+ " integer primary key autoincrement, "
            +COLUMN_NAME+ " varchar(50) not null,"
            +COLUMN_BRAND+ " varchar(50) not null, "
            +COLUMN_PRICE+ " varchar(50) not null); ";

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
