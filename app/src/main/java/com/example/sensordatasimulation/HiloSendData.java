package com.example.sensordatasimulation;

import com.google.firebase.database.DatabaseReference;

import static com.example.sensordatasimulation.SendData.stopsendingdata;

public class HiloSendData extends Thread{
    int timeparam =0;
    DatabaseReference ref;
    public HiloSendData(int tiemparam, DatabaseReference ref) {
        this.timeparam = tiemparam;
        this.ref = ref;
    }

        @Override
        public void run (){
                while(!stopsendingdata){
                    try {
                        String id_test = ref.child("test").push().getKey();
                        ref.child("Test").child(id_test).setValue("test cada "+ timeparam+" segundos");
                        sleep(timeparam*1000);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

        }

    }


