package varun.edu.asu.scannerapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


public class Exceptions extends ListActivity {

    static final String[] EXCEPTIONS = new String[] {

            "EXCEPTIONS:", "Patient absent", "Medication unavailable", "Patient refused medication", "Patient unable to take medication"
    };
    int room;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exceptions);
        Bundle extras = getIntent().getExtras();
        room = extras.getInt("myRub");
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, EXCEPTIONS){
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
        setContentView(R.layout.activity_exceptions);
        Button e = (Button) findViewById(R.id.button2);
        e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        if (position == 2) {
            new AlertDialog.Builder(Exceptions.this)
                    .setTitle("Contact details not available")
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
        else{
            super.onListItemClick(l, v, 1, id);
            Intent sam = new Intent(Exceptions.this, Next.class);
            sam.putExtra("myRub",room);
            sam.putExtra("excep",position);
            startActivity(sam);
        }


    }

}
