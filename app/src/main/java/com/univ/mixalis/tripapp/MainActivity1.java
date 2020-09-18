package com.univ.mixalis.tripapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.preference.PreferenceManager;

public class MainActivity1 extends AppCompatActivity {

    private static final String TAG = "MainActivity1";
    TextView read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button setTripBtn;
        Button emNumbers;
        Button tools;
        Button profile;
        Button LoadYourTrip;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //connects set trip button with xml
        setTripBtn = (Button) findViewById(R.id.idsetTripBtn);
        emNumbers = (Button) findViewById(R.id.idEmNum);
        tools = (Button) findViewById(R.id.tools);
        LoadYourTrip=(Button) findViewById(R.id.LoadYourTrip);
        profile = (Button) findViewById(R.id.profile);
        read = (TextView) findViewById(R.id.read);
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String name = mPreferences.getString(getString(R.string.name), "");
        read.setText(name);
        setTripBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
                finish();
            }

        });

        setTripBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
                finish();
            }

        });

        emNumbers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(i);
                finish();
            }

        });

        tools.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(i);
                finish();
            }

        });

        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity10.class);
                startActivity(i);
                finish();
            }

        });

        LoadYourTrip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoadTrip1Activity.class);
                startActivity(i);
                finish();
            }

        });
    }



}
