package com.univ.mixalis.tripapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.List;
import java.util.Locale;
import android.content.SharedPreferences;
import java.lang.Object;
import java.util.prefs.Preferences;
import java.lang.*;




public class MainActivity8 extends AppCompatActivity implements LocationListener {

    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    Typeface weatherFont;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String lat = "lngKey";
    public static final String lng = "latKey";
    public static final String counter = "counterKey";

    Button getLocationBtn;
    TextView locationText;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main8);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        getLocationBtn = (Button)findViewById(R.id.getLocationBtn);
        locationText = (TextView)findViewById(R.id.locationText);


        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);



            weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

            cityField = (TextView)findViewById(R.id.city_field);
            updatedField = (TextView)findViewById(R.id.updated_field);
            detailsField = (TextView)findViewById(R.id.details_field);
            currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
            humidity_field = (TextView)findViewById(R.id.humidity_field);
            pressure_field = (TextView)findViewById(R.id.pressure_field);
            weatherIcon = (TextView)findViewById(R.id.weather_icon);
            weatherIcon.setTypeface(weatherFont);
          /* Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
                public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                    cityField.setText(weather_city);
                    updatedField.setText(weather_updatedOn);
                    detailsField.setText(weather_description);
                    currentTemperatureField.setText(weather_temperature);
                    humidity_field.setText("Humidity: "+weather_humidity);
                    pressure_field.setText("Pressure: "+weather_pressure);
                    weatherIcon.setText(Html.fromHtml(weather_iconText));

                }
            });
           asyncTask.execute(sharedpreferences.getString(lat, ""),sharedpreferences.getString(lng,"")); //  asyncTask.execute("Latitude", "Longitude")*/

        }


        getLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(counter, true);
                editor.commit();
                getLocation();
                getLocationBtn.setVisibility(View.GONE);
                locationText.setVisibility(View.GONE);
            }
        });

    }




    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(lat,String.valueOf(location.getLatitude()));
        editor.putString(lng,String.valueOf(location.getLongitude()));
        editor.apply();
        if(sharedpreferences.getBoolean(counter,false)) {
            editor.putBoolean(counter, false);
            editor.apply();

            weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

            cityField = (TextView)findViewById(R.id.city_field);
            updatedField = (TextView)findViewById(R.id.updated_field);
            detailsField = (TextView)findViewById(R.id.details_field);
            currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
            humidity_field = (TextView)findViewById(R.id.humidity_field);
            pressure_field = (TextView)findViewById(R.id.pressure_field);
            weatherIcon = (TextView)findViewById(R.id.weather_icon);
            weatherIcon.setTypeface(weatherFont);

            Function.placeIdTask asyncTask = new Function.placeIdTask(new Function.AsyncResponse() {
                public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                    cityField.setText(weather_city);
                    updatedField.setText(weather_updatedOn);
                    detailsField.setText(weather_description);
                    currentTemperatureField.setText(weather_temperature);
                    humidity_field.setText("Humidity: " + weather_humidity);
                    pressure_field.setText("Pressure: " + weather_pressure);
                    weatherIcon.setText(Html.fromHtml(weather_iconText));

                }
            });
            asyncTask.execute(sharedpreferences.getString(lat, ""), sharedpreferences.getString(lng, "")); //  asyncTask.execute("Latitude", "Longitude")*/
        }
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));


        }catch(Exception e)
        {

        }

    }



    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(MainActivity8.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    public void onBackPressed(){

        Intent i = new Intent(this,MainActivity4.class);
        startActivity(i);
        finish();
    }



}