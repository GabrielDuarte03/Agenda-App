package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Adicionar extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private EditText nome;
    private Button data;
    private Button hora;
    private EditText obs;
    private EventoDAO eventoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);
        Button button = (Button) findViewById(R.id.data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        Button buthora = (Button) findViewById(R.id.hora);
        buthora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

        eventoDAO = new EventoDAO(this);

    }






    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String dia=String.valueOf(dayOfMonth), mes=String.valueOf(month);


        Button button = (Button) findViewById(R.id.data);
        if(dayOfMonth<10){
            dia = "0"+dayOfMonth;
        }
        if(month < 10){
            mes = "0"+month;
        }

        button.setText(dia+"/"+mes+"/"+year);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String hora=String.valueOf(hourOfDay);
        String minuto=String.valueOf(minute);


        Button buthora = (Button) findViewById(R.id.hora);
        if(hourOfDay<10){
            hora = "0"+hourOfDay;
        }
        if(minute < 10){
            minuto = "0"+minute;
        }
        buthora.setText(hora+":"+minuto+" hrs");

    }

    public void insert(View view) {

        String nomeT = "";
        String dataT = "";
        String horaT = "";
        String obsT = "a";

        nome = findViewById(R.id.nome);
        data = findViewById(R.id.data);
        hora = findViewById(R.id.hora);
        obs = findViewById(R.id.obs);

        nomeT = nome.getText().toString();
        dataT = data.getText().toString();
        horaT = hora.getText().toString();
        obsT = obs.getText().toString();



        /*
        *
        * INSERT DO BANCO AQUI
        *
        * */

        if(nomeT != "" && dataT != "" && horaT != "" ) {

            nome.setText("");
            data.setText("");
            hora.setText("");
            obs.setText("");


            Evento evento = new Evento();


            evento.setNome(nomeT);
            evento.setData(dataT);
            evento.setHora(horaT);
            evento.setObservacao(obsT);

            long obterId =  eventoDAO.insert(evento);

            String result = String.valueOf(obterId);
            Resources res = getResources();
            Drawable drawable = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                drawable = res.getDrawable(R.drawable.done, getTheme());
            }

            new AlertDialog.Builder(this)
                    .setTitle("Sucesso")
                    .setMessage("Evento adicionado com sucesso no ID " + result+".")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setIcon(drawable)
                    .show();

        }else{
            Resources res = getResources();
            Drawable drawable = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                drawable = res.getDrawable(R.drawable.error, getTheme());
            }

            new AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("Algum campo está vazio, revise todos os campos")
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
}