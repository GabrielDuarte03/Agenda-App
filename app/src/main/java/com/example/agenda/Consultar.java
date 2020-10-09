package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Consultar extends AppCompatActivity {

    private ListView listView;
    private EventoDAO dao;
    private List<Evento> eventoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        listView = findViewById(R.id.list);
        dao = new EventoDAO(this);

        eventoList = dao.select();

        ArrayAdapter<Evento> adapter = new ArrayAdapter<Evento>(this,android.R.layout.simple_list_item_1,eventoList);


        listView.setAdapter(adapter);

    }
}