package varun.edu.asu.scannerapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import varun.edu.asu.dataEHR_drugKnowledgeBase.EHR_medadmin;
import varun.edu.asu.datamodels.FHIR_MedAdmin;


public class Next extends ListActivity {

    String[] PatAbs;
    int room;
    int posi;
    String providerContact;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exceptions);
        Bundle extras = getIntent().getExtras();
        room = extras.getInt("myRub");
        posi=extras.getInt("excep");
        EHR_medadmin something = new EHR_medadmin();
        FHIR_MedAdmin medA = something.getRoomMedAdmin(room);
        providerContact = medA.getProviderContact();
        PatAbs = new String[3];
        for(int i=0; i<3;i++){
            if(i==0) {
                if(posi==1)
                PatAbs[i] = "Patient Absent";
                if(posi==2)
                    PatAbs[i] =  "Medication unavailable";
                if(posi==3)
                    PatAbs[i] =  "Patient refused medication";
                if(posi==4)
                    PatAbs[i] =  "Patient unable to take medication";
            }
            if(i==1)
                PatAbs[i] = "Call "+ medA.getProvider();
            if(i==2)
                PatAbs[i] = "Text "+medA.getProvider();
        }

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, PatAbs){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if(position==0){
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.RED);
                }
                else{
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLUE);}
                return view;
            }
        });
        getListView().setTextFilterEnabled(true);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        setContentView(R.layout.activity_next);
        Button e = (Button) findViewById(R.id.button2);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
        Button f = (Button) findViewById(R.id.button3);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent sam = new Intent(Next.this, RoomList.class);
                startActivity(sam);
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        if (position == 1) {
            super.onListItemClick(l, v, 1, id);
            EndCallListener callListener = new EndCallListener();
            TelephonyManager mTM = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
            mTM.listen(callListener, PhoneStateListener.LISTEN_CALL_STATE);
            String url = "tel:"+providerContact;
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
            startActivity(intent);
        }
        else{
            super.onListItemClick(l, v, 2, id);
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            String url = "sms:"+providerContact;
            sendIntent.setData(Uri.parse(url));
            startActivity(sendIntent);
        }

    }
    private class EndCallListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            if(TelephonyManager.CALL_STATE_RINGING == state) {
                Log.i("Drug5Right", "RINGING, number: " + incomingNumber);
            }
            if(TelephonyManager.CALL_STATE_OFFHOOK == state) {
                //wait for phone to go offhook (probably set a boolean flag) so you know your app initiated the call.
                Log.i("Drug5Right", "OFFHOOK");
            }
            if(TelephonyManager.CALL_STATE_IDLE == state) {
                //when this state occurs, and your flag is set, restart your app
                Log.i("Drug5Right", "IDLE");
            }
        }
    }
}
