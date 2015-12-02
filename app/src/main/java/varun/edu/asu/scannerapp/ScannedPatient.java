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

import varun.edu.asu.barcode.IntentIntegrator;
import varun.edu.asu.barcode.IntentResult;
import varun.edu.asu.dataEHR_drugKnowledgeBase.EHR_medadmin;
import varun.edu.asu.datamodels.FHIR_MedAdmin;


public class ScannedPatient extends ActionBarActivity {

    private ListView lv;
    int room;
    String NDC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_patient);
        SpannableString spannableString = new SpannableString(getString(R.string.rights));
        Bundle extras = getIntent().getExtras();
        room = extras.getInt("myRub");
        EHR_medadmin something = new EHR_medadmin();
        FHIR_MedAdmin medA = something.getRoomMedAdmin(room);
        //String he = "Room : "+room + "Patient : "+ medA.getPatientName()+ " DOB : "+medA.getDobs();
        NDC = medA.getNDC();
        Object greenSpan = new BackgroundColorSpan(Color.GREEN);
        //Object redSpan = new BackgroundColorSpan(Color.RED);
        spannableString.setSpan(greenSpan, 14, 21, 0);
        //spannableString.setSpan(redSpan, 6, spannableString.length(), 0);
        String[] allergy = medA.getAllergy();
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(spannableString);
        getSupportActionBar().setTitle("Patient Information");
        List<String> myList = new ArrayList<String>();
        for(int i =0; i<=allergy.length;i++){
            if(i==0)
                myList.add("Allergies: ");
            else
                myList.add(allergy[i-1]);
        }
        //myList.add("Allergies: ");
       // myList.add("1) Codeine");
       // myList.add("2) Penicillin");
        //myList.add("3) Peanuts");
        lv = (ListView) findViewById(R.id.listViewZ);
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
        Button b = (Button) findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new AlertDialog.Builder(ScannedPatient.this)
                        .setTitle("Scan Medication Barcode")
                        .setIcon(R.mipmap.pill24)
                        .setPositiveButton("NEXT",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        IntentIntegrator integrator = new IntentIntegrator(ScannedPatient.this);
                                        integrator.initiateScan();
                                    }
                                })
                        .show();

            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(resultCode!=0) {
            String code = scanResult.getContents();
            if(code.equalsIgnoreCase(NDC)) {
                Intent sam = new Intent(ScannedPatient.this, DrugInformation.class);
                sam.putExtra("myRub", room);
                startActivity(sam);
            }
            else{
                new AlertDialog.Builder(ScannedPatient.this)
                        .setTitle("Wrong Medication")
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
            new AlertDialog.Builder(ScannedPatient.this)
                    .setTitle("Drug barcode scan incomplete")
                    .setIcon(R.mipmap.band)
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }

    }


}
