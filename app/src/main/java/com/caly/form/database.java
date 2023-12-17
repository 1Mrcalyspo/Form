package com.caly.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class database extends SQLiteOpenHelper {
        public static final String name="Rita.db";
        public database(@Nullable Context context)
        {
            super(context,"Rita",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table users(Username text primary key ,Email text,Password text  )");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists users");
        }

        public boolean insertdata(String username,String email,String password )
        {
            SQLiteDatabase database=this.getReadableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put("Username",username);
            contentValues.put("Email",email);
            contentValues.put("Password",password);
            long result=database.insert("users",null,contentValues);
            if (result==-1) return false;
            else  return true;

        }
        public  boolean checkusername(String username)
        {
            SQLiteDatabase database=this.getWritableDatabase();
            Cursor cursor=database.rawQuery("select * from users where username =?",new String[]{username});
            if (cursor.getCount()>0) return true;
            else return false;

        }
        public  boolean checkemailpassword(String username,String password)
        {
            SQLiteDatabase database=this.getWritableDatabase();
            Cursor cursor=database.rawQuery("select * from users where username=? and password=?",new String[]{username,password});
            if (cursor.getCount()>0) return true;
            else return false;
        }

    }


