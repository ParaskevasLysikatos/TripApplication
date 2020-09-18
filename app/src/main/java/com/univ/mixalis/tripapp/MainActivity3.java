package com.univ.mixalis.tripapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    Button policeBtn;
    Button ambulanceButton;
    Button fireButton;
    Button euButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        policeBtn=(Button) findViewById(R.id.polBtn);
        ambulanceButton=(Button) findViewById(R.id.amBtn);
        fireButton=(Button) findViewById(R.id.firBtn);
        euButton=(Button) findViewById(R.id.euBtnn);

        policeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneno1="100";

                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneno1));
                startActivity(i);
                finish();

            }
        });

        ambulanceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneno2="166";

                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneno2));
                startActivity(i);
                finish();

            }
        });

        fireButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneno3="199";

                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneno3));
                startActivity(i);
                finish();

            }
        });

        euButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneno4="112";

                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneno4));
                startActivity(i);
                finish();

            }
        });
    }
    public void onBackPressed(){

        Intent i = new Intent(this,MainActivity1.class);
        startActivity(i);
        finish();

    }
}
