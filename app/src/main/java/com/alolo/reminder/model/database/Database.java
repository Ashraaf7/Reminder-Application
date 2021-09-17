package com.alolo.reminder.model.database;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.alolo.reminder.Control;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static final String Database_Name = "Project.db";
    public Database(Context con)
    {
        super(con,Database_Name,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase dp) {
        dp.execSQL("create table Users (U_name TEXT ,password TEXT NOT NULL, U_id INTEGER  primary key AUTOINCREMENT)");
        dp.execSQL("create table Accounts (A_name TEXT primary key,password TEXT NOT NULL, u_id INTEGER , FOREIGN KEY (u_id) REFERENCES Users (U_id))");
        dp.execSQL("create table Tasks (T_name TEXT primary key,deadline TEXT,t_id INTEGER , FOREIGN KEY (t_id) REFERENCES Users (U_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int Old, int New) {
        dp.execSQL("DROP TABLE  IF EXISTS Users");
        dp.execSQL("DROP TABLE  IF EXISTS Accounts");
        dp.execSQL("DROP TABLE  IF EXISTS Tasks");
        onCreate(dp);

    }

    public void Insert_User(String n,String p)
    {
        SQLiteDatabase s1=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("U_name",n);
        values.put("password",p);
        s1.insert("Users",null,values);
    }

    public void Insert_Account(String n,String p,int id)
    {
        SQLiteDatabase s2=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("A_name",n);
        values.put("password",p);
        values.put("u_id",id);
        s2.insert("Accounts",null,values);


    }

    public void Insert_Task(String n,String d, int id)
    {
        SQLiteDatabase s3=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("T_name",n);
        values.put("deadline",d);
        values.put("t_id",id);
        s3.insert("Tasks",null,values);

    }
    public ArrayList<Users> Get_Users()
    {
        SQLiteDatabase database = this.getReadableDatabase() ;
        Cursor cursor = database.rawQuery( "select * from Users", null);
        ArrayList<Users>  arrayList=new ArrayList<Users> ();


            cursor.moveToFirst();

        while(cursor.isAfterLast()==false)
        {
            arrayList.add(new Users(cursor.getString(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public  ArrayList<Accounts> Get_Accounts(int f){
        SQLiteDatabase database = this.getReadableDatabase() ;
        Cursor cursor = database.rawQuery( "select * from Accounts where u_id = '"+ f +"'", null);
        ArrayList<Accounts>  arrayList1 =new ArrayList<Accounts> ();
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false)
        {
            arrayList1.add(new Accounts(cursor.getString(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        return arrayList1;
    }


    public ArrayList<Tasks> Get_Tasks(int f)
    {
        SQLiteDatabase database = this.getReadableDatabase() ;
        Cursor cursor = database.rawQuery( "select * from Tasks where t_id = '"+ f +"' ", null);
        ArrayList<Tasks>  arrayList2 =new ArrayList<Tasks> ();
        cursor.moveToFirst();

        while(cursor.isAfterLast()==false)
        {
            arrayList2.add(new Tasks(cursor.getString(0),cursor.getString(1),cursor.getInt(2)));
            cursor.moveToNext();
        }
        return arrayList2;
    }


}
