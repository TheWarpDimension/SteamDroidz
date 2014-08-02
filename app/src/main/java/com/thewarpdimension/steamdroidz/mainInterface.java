package com.thewarpdimension.steamdroidz;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.app.ListFragment;
import android.widget.ListView;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.List;
import android.view.ViewGroup;
import android.view.LayoutInflater;

///////////////////////////////////
//          READ ME!!!!          //
// To get username:              //
// loginInterface.username       //
// To get password:              //
// loginInterface.password       //
///////////////////////////////////

public class mainInterface extends ListActivity {

    ListView m_list;
    public ArrayList<String> listItems = new ArrayList<String>();
    public ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        m_list   = (ListView)findViewById(android.R.layout.simple_list_item_1);
        setContentView(R.layout.activity_main_interface);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.w("SteamDroidz", "Sent message.");
                addMessage("test", "test");
            }
        });

        };

        String personaname = "/TWD\\ Boncey";

        /*@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_interface);
        }*/

        public void addMessage(String user, String text) {
            listItems.add(0, user + ": " + text);
            adapter.notifyDataSetChanged();
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main_interface, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
}