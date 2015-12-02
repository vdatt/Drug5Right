package varun.edu.asu.scannerapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

import varun.edu.asu.barcode.IntentIntegrator;
import varun.edu.asu.barcode.IntentResult;
import varun.edu.asu.dataEHR_drugKnowledgeBase.EHR_medadmin;
import varun.edu.asu.datamodels.FHIR_MedAdmin;


public class PatientInfo extends ActionBarActivity {

    private ListView lv;
    int room;
    String MRN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        getSupportActionBar().setTitle("Medications Due");
        getSupportActionBar().setIcon(R.mipmap.ic_action_pill);
        Bundle extras = getIntent().getExtras();
        room = extras.getInt("myRub");
        EHR_medadmin something = new EHR_medadmin();
        FHIR_MedAdmin medA = something.getRoomMedAdmin(room);
        String he = "Room : "+room + "Patient : "+ medA.getPatientName()+ " DOB : "+medA.getDobs();
        MRN = medA.getPatientMRN();
        List<String> myList = new ArrayList<String>();
        String med = medA.getDrug()+ " "+medA.getDose()+ " " +medA.getDoseUnits()+ " " + medA.getPackaging();
        myList.add(med);
        //myList.add(he);
        lv = (ListView) findViewById(R.id.listViewinfo);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                text.setTextSize(25);
                return view;
            }
        };
        TextView textView = (TextView) findViewById(R.id.textView);
        String old=textView.getText().toString();
        String news= old+room+"\n\nPatient :"+medA.getPatientName()+"\n\nDOB : "+medA.getDobs();

        textView.setText(news);
        textView.setTextSize(18);
        textView.setTypeface(null, Typeface.BOLD);

        lv.setAdapter(arrayAdapter);
        Button b = (Button) findViewById(R.id.buttonScan);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(PatientInfo.this)
                        .setTitle("Scan Wristband")
                        .setIcon(R.mipmap.band)
                        .setPositiveButton("NEXT",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        IntentIntegrator integrator = new IntentIntegrator(PatientInfo.this);
                                            integrator.initiateScan();
                                    }
                                })
                        .show();
            }
        });
        //ActionBar bar = getActionBar();
        //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
        Button e = (Button) findViewById(R.id.button2);
        e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                                        Intent sam = new Intent(PatientInfo.this, Exceptions.class);
                                        sam.putExtra("myRub",room);
                                        startActivity(sam);


            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(resultCode!=0) {
            String code = scanResult.getContents();
            if(code.equalsIgnoreCase(MRN)){
            Intent sam = new Intent(PatientInfo.this, ScannedPatient.class);
            sam.putExtra("myRub",room);
            startActivity(sam);}
            else{
                new AlertDialog.Builder(PatientInfo.this)
                        .setTitle("Wrong Patient")
                        .setIcon(R.mipmap.band)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        }
        else{
            new AlertDialog.Builder(PatientInfo.this)
                    .setTitle("Wristband scan incomplete")
                    .setIcon(R.mipmap.band)
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_patient_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
