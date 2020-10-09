package com.example.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name="bdEventos.db";
    private static final int version=1;
   // private static final int factory="";



    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table tbEvento(" +
                "idEvento integer primary key autoincrement," +
                "nomeEvento varchar(40)," +
                "dataEvento varchar(15)," +
                "horaEvento varchar(20)," +
                "observacaoEvento varchar(1000))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* String sql = "drop table if exists tbEvento";
        db.execSQL(sql);
        onCreate(db);*/
    }
}