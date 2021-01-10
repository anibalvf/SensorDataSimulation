package com.example.sensordatasimulation;

import static com.example.sensordatasimulation.SendData.stopsendingdata;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class InverterThread extends Thread implements Serializable {
    int timeparam =0;
    DatabaseReference ref;

    Inverter inverter;

    public InverterThread(int tiemparam, DatabaseReference ref,Inverter in) {
        this.timeparam = tiemparam;
        this.ref = ref;

        this.inverter=in;
    }

    @Override
    public void run (){
        Random r = new Random();
        addInverter();
        ArrayList<Integer> inverterLectures = new ArrayList<Integer>();
        while(!stopsendingdata){
            try {
                for (int j = 0; j < 8; j++) {

                    if(j<=4){
                        inverterLectures.add(r.nextInt(2));
                    }else{
                        inverterLectures.add(r.nextInt(1000)+1001);
                    }
                }

                ref.child("Inversores").child(this.inverter.id).child("zlectures").setValue(inverterLectures);
                sleep(timeparam*1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    private void addInverter(){
        this.inverter.id = ref.child("Inversores").push().getKey();

        ref.child("Inversores").child(this.inverter.id).setValue(this.inverter);
    }

}
