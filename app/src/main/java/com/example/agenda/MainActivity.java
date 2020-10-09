package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adicionar(View view){
        Intent ir;
        ir = new Intent(this,Adicionar.class);
        startActivity(ir);

    }
    public void excluir(View view){
        Intent ir;
        ir = new Intent(this,Excluir.class);
        startActivity(ir);
    }
    public void consultar(View view){
        Intent ir;
        ir = new Intent(this,Consultar.class);
        startActivity(ir);
    }
}