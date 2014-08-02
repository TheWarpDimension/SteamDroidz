package com.thewarpdimension.steamdroidz;


import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import android.util.Log;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.app.ListFragment;
import android.widget.ListView;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import java.util.List;
import android.view.ViewGroup;
import android.view.LayoutInflater;

public class loginInterface extends Activity {

    public static String username;
    public static String password;

    EditText mEdit;
    EditText mEdit2;
    Button mButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_interface);

        mButton = (Button)findViewById(R.id.button);
        mEdit   = (EditText)findViewById(R.id.editText);
        mEdit2   = (EditText)findViewById(R.id.editText2);

        mEdit.setTextColor(Color.BLACK);
        mEdit2.setTextColor(Color.BLACK);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        username = mEdit.getText().toString();
                        password = mEdit2.getText().toString();
                        Log.v("SteamDroidz", "Username: " + username);
                        Log.v("SteamDroidz", "Password: " + password);
                        Intent goToNextActivity = new Intent(getApplicationContext(), mainInterface.class);
                        startActivity(goToNextActivity);
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_interface, menu);
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
