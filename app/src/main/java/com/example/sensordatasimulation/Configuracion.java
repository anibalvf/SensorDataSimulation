package com.example.sensordatasimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity {
    TextView tvminutos,tvsegundos;
    private SharedPreferences sp ;
    private SharedPreferences.Editor se;
    public int minutos,segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        sp = this.getSharedPreferences("CONFIG", this.MODE_PRIVATE);
        se = sp.edit();

        getShared();
        linkView();

    }

    public void linkView(){
        tvminutos = (TextView)findViewById(R.id.tvminutos);
        tvsegundos = (TextView)findViewById(R.id.tvsegundos);
        tvminutos.setText(Integer.toString(minutos));
        tvsegundos.setText(Integer.toString(segundos));
    }

    public void getShared(){
        minutos = sp.getInt("MINUTOS",0);
        segundos = sp.getInt("SEGUNDOS",5);
    }



    public void sumarTiempo(View v){
        Button b = (Button)v;
        int tiempo;
        if (b.getId() == R.id.bsumarminutos){
            tiempo = Integer.parseInt(tvminutos.getText().toString().trim());
            if (tiempo <60){
                tiempo+=1;
                tvminutos.setText(Integer.toString(tiempo));
                minutos = tiempo;
            }
        }else{
            tiempo = Integer.parseInt(tvsegundos.getText().toString().trim());
            if (tiempo <59){
                tiempo+=1;
            }else {
                tiempo = 0;
                tvminutos.setText(Integer.toString(Integer.parseInt(tvminutos.getText().toString().trim())+1));
            }
                tvsegundos.setText(Integer.toString(tiempo));
            segundos = tiempo;
        }

    }

    public void restarTiempo(View v){
        Button b = (Button)v;
        int tiempo;
        if (b.getId() == R.id.brestarminutos){
            tiempo = Integer.parseInt(tvminutos.getText().toString().trim());
            if (tiempo >0){
                tiempo-=1;
            }else{
                tiempo = 0;
            }
                tvminutos.setText(Integer.toString(tiempo));
            minutos = tiempo;
        }else{
            tiempo = Integer.parseInt(tvsegundos.getText().toString().trim());
            if (tiempo >1 && tiempo!= 1){
                tiempo-=1;
            }else{
                Toast.makeText(this, "El minimo es 1 segundo", Toast.LENGTH_SHORT).show();
                tiempo = 1;
            }
            tvsegundos.setText(Integer.toString(tiempo));
            segundos = tiempo;
        }

    }
    public void reset(View v){
        se.clear();
        minutos= 0;
        segundos = 5;

        tvminutos.setText(Integer.toString(0));
        tvsegundos.setText(Integer.toString(5));
        se.commit();

    }

    public void guardar(View v){
        se.putInt("MINUTOS",minutos);
        se.putInt("SEGUNDOS",segundos);

//        Toast.makeText(this, "Minutos: "+minutos+" Segundos: "+segundos, Toast.LENGTH_SHORT).show();
        se.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}