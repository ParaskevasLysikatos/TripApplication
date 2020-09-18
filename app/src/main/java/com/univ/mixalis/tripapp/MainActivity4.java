package com.univ.mixalis.tripapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button compass;
        Button torch;
        Button maps;
        Button CurrentWeather;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        compass = (Button) findViewById(R.id.compass);
        torch = (Button) findViewById(R.id.torch);
        maps = (Button) findViewById(R.id.maps);
        CurrentWeather = (Button) findViewById(R.id.CurrentWeather);

        compass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(i);
                finish();
            }

        });



        torch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(i);
                finish();
            }

        });

        maps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(i);
                finish();
            }

        });

        CurrentWeather.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity8.class);
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
