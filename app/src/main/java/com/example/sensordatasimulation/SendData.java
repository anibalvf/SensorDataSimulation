package com.example.sensordatasimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static java.lang.Thread.sleep;

public class SendData extends AppCompatActivity {
    private SharedPreferences sp ;
    private SharedPreferences.Editor se;
    private DatabaseReference ref;
    private StorageReference sto;
    public static boolean stopsendingdata = false;
    private int timeparam;
    private InverterThread inverter1;
    private StringInverterThread stringInverterThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        stopsendingdata = false;

        sp = this.getSharedPreferences("CONFIG", this.MODE_PRIVATE);
        ref = FirebaseDatabase.getInstance().getReference();
        sto = FirebaseStorage.getInstance().getReference();
        timeparam = sp.getInt("SEGUNDOS",0);
        int minutos = sp.getInt("MINUTOS",-1);
        if (minutos!=0 && minutos!=-1){
            timeparam = timeparam + (minutos*60);
        }
        Inverter inverter = new Inverter("1","SUNNY BOY 3.0","sunny-boy-30",502,3000);
        inverter1 = new InverterThread(timeparam,ref,inverter);

        StringInverter stringInverter = new StringInverter("1", 0, 0);
        stringInverterThread = new StringInverterThread(timeparam,ref,stringInverter);

        startSendingData();

    }

    private void startSendingData(){
        inverter1.start();
        stringInverterThread.start();
    }

    public void stopsenddata(View v ){
        stopsendingdata = true;
        Toast.makeText(this, "Fest Finalizado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}