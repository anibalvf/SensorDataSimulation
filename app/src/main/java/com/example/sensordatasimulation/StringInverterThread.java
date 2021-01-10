package com.example.sensordatasimulation;
import static com.example.sensordatasimulation.SendData.stopsendingdata;
        import com.google.firebase.database.DatabaseReference;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.Random;

public class StringInverterThread extends Thread implements Serializable {
    int timeparam =0;
    DatabaseReference ref;

    StringInverter stringInverter;

    public StringInverterThread(int tiemparam, DatabaseReference ref,StringInverter st) {
        this.timeparam = tiemparam;
        this.ref = ref;

        this.stringInverter=st;
    }

    @Override
    public void run (){
        Random r = new Random();
        addString();
        ArrayList<Integer> StringsLectures = new ArrayList<Integer>();
        while(!stopsendingdata){
            try {
                for (int j = 0; j < 5; j++) {

                    if(j<=2){
                        StringsLectures.add(r.nextInt(2));
                    }else{
                        StringsLectures.add(r.nextInt(1000)+1001);
                    }
                }

                ref.child("Strings").child(this.stringInverter.id).child("zlectures").setValue(StringsLectures);
                sleep(timeparam*1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }



    private void addString(){
        this.stringInverter.id = ref.child("Strings").push().getKey();

        ref.child("Strings").child(this.stringInverter.id).setValue(this.stringInverter);
    }

}
