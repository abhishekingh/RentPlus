package com.example.RentPlus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_connection extends SQLiteOpenHelper {
    private static final String database_name="entry_data";
    private static String table_name="entry";
    private static String table_name2="billing";
    Database_connection(Context context){
        super(context,database_name,null,4);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+table_name+"" +
                "(name varchar(30),password varchar(20) primary key,phone text,address varchar(30))");
        db.execSQL("create table if not exists "+table_name2+
                "(id int ,monthly int not null,electricity int,other int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table_name);
        db.execSQL("drop table if exists "+table_name2);
        onCreate(db);
    }
    public void insert(String name,String password,String phone,String address){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        contentValues.put("address",address);
        database.insert(table_name,null,contentValues);
    }
    public void insert2(int id,int monthly,int electricity,int other){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("monthly",monthly);
        contentValues.put("electricity",electricity);
        contentValues.put("other",other);
        database.insert(table_name2,null,contentValues);
    }
    public Cursor select(){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select name,password from "+table_name,null);
        return cursor;
    }
    public Cursor select2(int x){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+table_name2+" where id= "+x,null);
        return cursor;
    }
}
