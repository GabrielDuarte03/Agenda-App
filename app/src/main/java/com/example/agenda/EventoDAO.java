package com.example.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private Conexao conexao;
    private SQLiteDatabase bd;

    public EventoDAO(Context context){
        conexao = new Conexao(context);
        bd = conexao.getWritableDatabase();
    }

    public long insert(Evento evento){

        ContentValues values = new ContentValues();
        values.put("nomeEvento",evento.getNome());
        values.put("dataEvento",evento.getData());
        values.put("horaEvento",evento.getHora());
        values.put("observacaoEvento", evento.getObservacao());
        return bd.insert("tbEvento",null,values);
    }

    public void delete(long id){

        String [] a = {String.valueOf(id)};
        bd.delete("tbEvento","idEvento = ?",a);


    }

    public List<Evento> select(){

        List<Evento> evento = new ArrayList<>();

        Cursor cursor = bd.query("tbEvento", new String[]{"idEvento","nomeEvento","dataEvento","horaEvento","observacaoEvento"}, null,
                null,
                null,
                null,
                null );

        while(cursor.moveToNext()){
            Evento evento1 = new Evento();
            evento1.setIdEvento(cursor.getInt(0));
            evento1.setNome(cursor.getString(1));
            evento1.setData(cursor.getString(2));
            evento1.setHora(cursor.getString(3));
            evento1.setObservacao(cursor.getString(4));

            evento.add(evento1);
        }

        return evento;
    }




}
