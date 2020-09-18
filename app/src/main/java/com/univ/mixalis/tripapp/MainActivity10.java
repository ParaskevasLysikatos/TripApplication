package com.univ.mixalis.tripapp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.preference.PreferenceManager;


public class MainActivity10 extends AppCompatActivity {

    private static final String TAG = "MainActivity10";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    EditText read;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        save = (Button) findViewById(R.id.save);
        read = (EditText) findViewById(R.id.text);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the name
                String name = read.getText().toString();
                mEditor.putString(getString(R.string.name), name);
                mEditor.commit();
                Intent intent = new Intent(MainActivity10.this, MainActivity1.class);
                startActivity(intent);
            }
        });
    }

    private void checkSharedPreferences() {
        String name = mPreferences.getString(getString(R.string.name), "");
        read.setText(name);
    }


    public void onBackPressed(){

        Intent i = new Intent(this,MainActivity1.class);
        startActivity(i);
        finish();

    }
}
