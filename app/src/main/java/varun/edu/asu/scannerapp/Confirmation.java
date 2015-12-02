package varun.edu.asu.scannerapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import varun.edu.asu.dataEHR_drugKnowledgeBase.EHR_medadmin;
import varun.edu.asu.datamodels.FHIR_MedAdmin;


public class Confirmation extends ActionBarActivity {

    private ListView lv;
    int room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        getSupportActionBar().setTitle("CHARTED");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
        Bundle extras = getIntent().getExtras();
        room = extras.getInt("myRub");
        EHR_medadmin something = new EHR_medadmin();
        FHIR_MedAdmin medA = something.getRoomMedAdmin(room);
        String patient = "Patient - "+medA.getPatientName();
        String drug = "Drug - "+medA.getDrug();
        String dose = "Dose - " + medA.getDose()+medA.getDoseUnits()+" "+medA.getPackaging();
        String route = "Route - "+medA.getRouteOfAdmin();
        String time = "Time due - "+ medA.getTimeDue().substring(11);
        List<String> myList = new ArrayList<String>();
        medA.setComplete(true);
        myList.add(patient);
        myList.add(drug);
        myList.add(dose);
        myList.add(route);
        myList.add(time);
        Calendar c = Calendar.getInstance();
        int seconds = c.get(Calendar.HOUR);
        int some = c.get(Calendar.AM_PM);
        int thing = c.get(Calendar.MINUTE);
        String am;
        if(some==0)
            am= "AM";
        else
            am= "PM";
        String ts;
        if((int)(Math.log10(thing)+1)==1) {
            if((int)(Math.log10(seconds)+1)==1)
            ts = "Administered time - 0" + seconds + ":0" + thing + am;
            else
                ts = "Administered time - " + seconds + ":0" + thing + am;
        }else {
            if((int)(Math.log10(seconds)+1)==1)
                ts = "Administered time - 0" + seconds + ":" + thing + am;
            else
                ts = "Administered time - " + seconds + ":" + thing + am;
        }
        myList.add(ts);
        lv = (ListView) findViewById(R.id.listView4);

        Log.i("Drug5Right", myList.toString());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myList ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                text.setTextSize(23);
                return view;
            }
        };

        lv.setAdapter(arrayAdapter);
        Button b = (Button) findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent sam = new Intent(Confirmation.this, ListviewActivity.class);
                sam.putExtra("complete",room);
                startActivity(sam);
            }
        });
    }

}
