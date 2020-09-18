package com.univ.mixalis.tripapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button backBtn;
    CheckBox checkBox1,checkBox2,checkBox3;
    EditText EditText1,EditText2,EditText3;
    Button saveBtn;
    //LinearLayout with children checkboxes
    LinearLayout llayout;
    //Array of size = Layout size
    String [] isCheckedKeyArray;
    boolean goToValid = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backBtn = (Button) findViewById(R.id.idBackBtn);
        saveBtn= (Button) findViewById(R.id.idSaveBtn);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox10);
        llayout = (LinearLayout) findViewById(R.id.LinearLayoutId);
        isCheckedKeyArray = new String[llayout.getChildCount()];
        isCheckedKeyArray[0] = "0";
        isCheckedKeyArray[1] = "1";
        isCheckedKeyArray[2] = "2";
        isCheckedKeyArray[3] = "3";
        isCheckedKeyArray[4] = "4";
        isCheckedKeyArray[5] = "5";
        isCheckedKeyArray[6] = "6";
        isCheckedKeyArray[7] = "7";
        isCheckedKeyArray[8] = "8";
        isCheckedKeyArray[9] = "9";
        EditText1 = (EditText) findViewById(R.id.idEditText1);
        EditText2 = (EditText) findViewById(R.id.idEditText2);
        EditText3 = (EditText) findViewById(R.id.idEditText3);
    }

    public void onClickSave(View v)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("TripData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (isValid(EditText1) && isValid(EditText2) && isValid(EditText3)) {
            for (int i = 0; i < llayout.getChildCount(); i++) {
                CheckBox cb = (CheckBox) llayout.getChildAt(i);
                editor.putBoolean(isCheckedKeyArray[i], cb.isChecked());
                if (cb.isChecked()) {
                    Toast.makeText(this, "Item:" + i + "Saved", Toast.LENGTH_SHORT).show();
                }
            }
            editor.putInt("duration", Integer.parseInt(EditText1.getText().toString()));
            editor.putInt("budget", Integer.parseInt(EditText2.getText().toString()));
            editor.putInt("countdown", Integer.parseInt(EditText3.getText().toString()));
            editor.putLong("currentTime",System.currentTimeMillis());
            editor.apply();
            goToValid = true;

        }
        else{
            Toast.makeText(this, "Some text fields are left empty or contain weird symbols!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isValid(EditText y){
        boolean flag = false;
        if (y.getText().toString().equals("")){
            return false;
        }
        else
        {
            for(int i=0; i<y.getText().toString().length(); i++ ) {
                if (y.getText().toString().charAt(i) == '1' || y.getText().toString().charAt(i) == '2' || y.getText().toString().charAt(i) == '3' || y.getText().toString().charAt(i) == '4' || y.getText().toString().charAt(i) == '5' || y.getText().toString().charAt(i) == '6' || y.getText().toString().charAt(i) == '7' || y.getText().toString().charAt(i) == '8' || y.getText().toString().charAt(i) == '9' || y.getText().toString().charAt(i) == '0' ) {
                    flag = true;
                }
                else{
                    flag = false;
                }
                if(!flag){
                    return false;
                }
            }
            return true;
        }
    }

    public void goToSavedTrip(View v)
    {
        if (goToValid) {
            Toast.makeText(this, "This is the trip you have just saved!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,LoadTrip1Activity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "There is no saved trip that you can see!", Toast.LENGTH_LONG).show();
        }
    }

    public void onBackPressed(){

        Intent i = new Intent(this,MainActivity1.class);
        startActivity(i);
        finish();

    }
}
