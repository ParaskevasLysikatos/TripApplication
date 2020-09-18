package com.univ.mixalis.tripapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class LoadTrip1Activity extends AppCompatActivity {

    //declarations
    boolean [] itemState;
    int numberOfCheckBoxes = 10;
    String key;
    public static final boolean DEFAULT = false;
    String [] itemNames = {"Bag","Blouse","Burgers","Hair spray","Hammer","Lighter","Nails","Pants","T-shirt","Tent"};
    String finalText = "";
    TextView neededItems,budgetPerDay;
    boolean flag = false;
    int duration,budget,finalbudget,days;
    long oldtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_trip1);
        itemState = new boolean [numberOfCheckBoxes];
    }

    public void onClickLoad(View v)
    {
        //if the button is clicked for the first time information is loaded into the text fields, otherwise a message is displayed
        if(!flag) {
            flag = true;
            SharedPreferences sharedPreferences = getSharedPreferences("TripData", Context.MODE_PRIVATE);

            //loading the checkbox states
            itemState[0] = sharedPreferences.getBoolean("0", DEFAULT);
            itemState[1] = sharedPreferences.getBoolean("1", DEFAULT);
            itemState[2] = sharedPreferences.getBoolean("2", DEFAULT);
            itemState[3] = sharedPreferences.getBoolean("3", DEFAULT);
            itemState[4] = sharedPreferences.getBoolean("4", DEFAULT);
            itemState[5] = sharedPreferences.getBoolean("5", DEFAULT);
            itemState[6] = sharedPreferences.getBoolean("6", DEFAULT);
            itemState[7] = sharedPreferences.getBoolean("7", DEFAULT);
            itemState[8] = sharedPreferences.getBoolean("8", DEFAULT);
            itemState[9] = sharedPreferences.getBoolean("9", DEFAULT);

            //loading through SharedPreferences the duration and budget
            duration = sharedPreferences.getInt("duration", 1);
            budget = sharedPreferences.getInt("budget", 1);
            finalbudget = budget / duration;

            days = sharedPreferences.getInt("countdown",0);
            oldtime = sharedPreferences.getLong("currentTime", 0);

            //finding what checkboxes are checked and adding their names to the final text that should be displayed
            for (int i = 0; i < numberOfCheckBoxes; i++) {
                if (itemState[i]) {
                    finalText += itemNames[i] + ", ";
                } else {
                    Toast.makeText(this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
            //display items
            TextView neededItems = (TextView) findViewById(R.id.ItemsNeedET);
            neededItems.setText(removeComa(finalText));

            //display budget per day
            TextView budgetPerDay = (TextView) findViewById(R.id.BudgetPerDay);
            budgetPerDay.setText("" + finalbudget + " $");

            //display days for trip
            TextView daysLeft = (TextView) findViewById(R.id.DaysLeft);
            daysLeft.setText(calculateTime(days,oldtime) + " days left!");
        }
        else{
            Toast.makeText(this, "You have already loaded this trip!", Toast.LENGTH_LONG).show();
        }

    }

    //returns a String without the last appended comma
    public String removeComa(String x){
        x = x.substring(0,x.length() - 2);
        return x;
    }

    //returns a long of days left for the trip
    public long calculateTime(int y,long o){
        long z = y * 24 * 60 * 60 * 1000;
        long w = System.currentTimeMillis() - o + z;
        return TimeUnit.MILLISECONDS.toDays(w);
    }

    public void onBackPressed(){

        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
        finish();

    }
}
