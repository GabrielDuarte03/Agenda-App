package com.example.agenda;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Excluir extends AppCompatActivity  {

    private EditText id;
    private Button butao;
    private EventoDAO eventoDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir);
        Resources res = getResources();
        Drawable drawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = res.getDrawable(R.drawable.alert, getTheme());
        }
        new AlertDialog.Builder(this)
                .setTitle("Atenção!")
                .setMessage("Para excluir algum evento, tenha em mãos o ID dele (consulte o ID no botão 'Ver os Eventos') e tenha certeza de que ele está correto.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(drawable)
                .show();

         Toast.makeText(this,",",Toast.LENGTH_LONG);
    }


    public void excluir(View view) {

        /*
         * TO DO: COLOCAR CONFIRMAÇÃO
         *
         * */
        id = findViewById(R.id.textid);
        String verId = id.getText().toString();
        eventoDAO = new EventoDAO(this);

        if (verId.equals("")) {


            Resources res = getResources();
            Drawable drawable = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                drawable = res.getDrawable(R.drawable.error, getTheme());
            }

            new AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("O campo está vazio")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(drawable)
                    .show();
        } else {
            Resources res = getResources();
            Drawable drawable = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                drawable = res.getDrawable(R.drawable.alert, getTheme());
            }
            new AlertDialog.Builder(this)
                    .setTitle("Atenção!")
                    .setMessage("Tem certeza que deseja apagar esse evento?\nCaso você apague, será impossível recuperá-lo.")
                    .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            long a = 0;

                            try {
                                String naoAguento = id.getText().toString();
                                a = Long.parseLong(naoAguento);
                            } catch (Exception e) {

                            }
                            eventoDAO.delete(a);

                            id.setText("");
                            sucesso();


                        }
                    })
                    .setIcon(drawable)
                    .show();

        }

    }
    public void sucesso(){
        Resources res = getResources();
        Drawable drawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = res.getDrawable(R.drawable.done, getTheme());
        }

        new AlertDialog.Builder(this)
                .setTitle("Sucesso")
                .setMessage("Evento removido com sucesso!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(drawable)
                .show();
    }

}