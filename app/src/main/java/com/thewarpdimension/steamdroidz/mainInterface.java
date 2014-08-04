package com.thewarpdimension.steamdroidz;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.app.ListFragment;
import android.widget.ListView;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
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

    public ListView m_list;
    public ArrayList<String> listItems = new ArrayList<String>();
    public ArrayAdapter<String> adapter;

    public EditText m_messageBox;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_main_interface);

        m_messageBox = (EditText)findViewById(R.id.editText3);
        ListView m_list   =  getListView();

        adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);

        m_list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_NORMAL);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    if (!(m_messageBox.getText().toString().equals(""))) {
                        addMessage("test", m_messageBox.getText().toString());
                        m_messageBox.setText("");
                    }
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
            listItems.add(adapter.getCount(), user + ": " + text);
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
