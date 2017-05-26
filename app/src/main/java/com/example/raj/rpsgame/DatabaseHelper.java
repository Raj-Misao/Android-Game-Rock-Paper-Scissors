package com.example.raj.rpsgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sonu on 21-May-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    public static String DBNAME = "Login";
    public DatabaseHelper(Context context) {
        super(context,DBNAME , null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userinfo(id integer auto_increment primary key, Name varchar(50), Email varchar(100), Phone varchar(50), Password varchar(100))");
        sqLiteDatabase = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            this.onCreate(db);
    }

    public void insert(String name, String email, String phone, String password)
    {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        cv.put("Email",email);
        cv.put("Phone",phone);
        cv.put("Password",password);
        sqLiteDatabase.insert("userinfo",null,cv);
    }

    public Cursor getData(String email, String password)
    {
        sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("Select * from userinfo where Email='"+email+"' and Password='"+password+"'",null);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            return c;
        }
        c.close();
        return null;
    }
}
