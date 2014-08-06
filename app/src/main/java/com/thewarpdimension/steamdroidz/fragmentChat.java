package com.thewarpdimension.steamdroidz;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import java.util.ArrayList;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

///////////////////////////////////
//          READ ME!!!!          //
// To get username:              //
// loginInterface.username       //
// To get password:              //
// loginInterface.password       //
///////////////////////////////////

    public class fragmentChat extends Fragment {

        public ListView m_list;
        public ArrayList<String> listItems = new ArrayList<String>();
        public ArrayAdapter<String> adapter;

        public EditText m_messageBox;

        public static Fragment newInstance(Context context) {
            fragmentChat f = new fragmentChat();

            return f;
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

            ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_chat, null);

            m_messageBox = (EditText) root.findViewById(R.id.editText3);
            m_list = (ListView) root.findViewById(android.R.id.list);

            adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.simple_list_item_1, listItems);
            m_list.setAdapter(adapter);

            m_list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_NORMAL);

            final Button button = (Button) root.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!(m_messageBox.getText().toString().equals(""))) {
                        addMessage("test", m_messageBox.getText().toString());
                        m_messageBox.setText("");
                    }
                }
            });
            return root;

        };

        String personaname = "/TWD\\ Boncey";

        /*@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_chat);
        }*/

        public void addMessage(String user, String text) {
            listItems.add(adapter.getCount(), user + ": " + text);
            adapter.notifyDataSetChanged();
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