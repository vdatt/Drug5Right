package varun.edu.asu.scannerapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import varun.edu.asu.dataEHR_drugKnowledgeBase.EHR_medadmin;
import varun.edu.asu.datamodels.FHIR_MedAdmin;


public class DrugInformation extends ActionBarActivity {

    private ListView lv;
    int room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_information);
        getSupportActionBar().setTitle("Drug Information");
        Bundle extras = getIntent().getExtras();
        room = extras.getInt("myRub");
        EHR_medadmin something = new EHR_medadmin();
        FHIR_MedAdmin medA = something.getRoomMedAdmin(room);
        SpannableString spannableString = new SpannableString(getString(R.string.rights));
        Object greenSpan = new BackgroundColorSpan(Color.GREEN);
        //Object redSpan = new BackgroundColorSpan(Color.RED);
        spannableString.setSpan(greenSpan, 14, 42, 0);
        //spannableString.setSpan(redSpan, 6, spannableString.length(), 0);
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(spannableString);
        String drug = "Drug - "+medA.getDrug();
        String dose = "Dose - " + medA.getDose()+medA.getDoseUnits()+" "+medA.getPackaging();
        String route = "Route - "+medA.getRouteOfAdmin();
        String time = "Time due - "+ medA.getTimeDue().substring(11);
        List<String> myList = new ArrayList<String>();
        myList.add(drug);
        myList.add(dose);
        myList.add(route);
        myList.add(time);
        lv = (ListView) findViewById(R.id.listViewinfo);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myList ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                text.setTextSize(25);
                return view;
            }
        };
        TextView textViews = (TextView) findViewById(R.id.textView);
        String old=textViews.getText().toString();
        String news= old+room+"\n\nPatient :"+medA.getPatientName()+"\n\nDOB : "+medA.getDobs();

        textViews.setText(news);
        textViews.setTextSize(18);
        textViews.setTypeface(null, Typeface.BOLD);
        lv.setAdapter(arrayAdapter);
        Button b = (Button) findViewById(R.id.buttonNext1);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new AlertDialog.Builder(DrugInformation.this)
                        .setTitle("Confirm")
                        .setMessage(R.string.confirm)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent sam = new Intent(DrugInformation.this, Confirmation.class);
                                        sam.putExtra("myRub", room);
                                        startActivity(sam);
                                    }
                                })
                        .show();

            }
        });

    }



}
