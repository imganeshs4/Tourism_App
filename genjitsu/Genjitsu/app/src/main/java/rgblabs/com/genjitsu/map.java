package rgblabs.com.genjitsu;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class map extends Activity {

    Button btnShowLocation;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    // GPSTracker class
    GPSTracker gps;
    TextView t;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        t =(TextView) findViewById(R.id.city);
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition willexecute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnShowLocation = (Button) findViewById(R.id.button);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSTracker(map.this);

                // check if GPS enabled
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Geocoder geocoder = new Geocoder(map.this, Locale.getDefault());
                    // \n is for new line
                    List<Address> addresses = null;
                    try {
                        addresses = geocoder.getFromLocation(
                                latitude,
                                longitude,
                                // In this sample, get just a single address.
                                1);
                        String a = addresses.get(0).getLocality();
                        t.setVisibility(View.VISIBLE);
                        t.setText("Welcome to "+a);

                        Toast.makeText(getApplicationContext(), "Your Location is - \n " + a, Toast.LENGTH_LONG).show();
                        final Handler handler = new Handler();
                        final Intent i = new Intent(map.this,places.class);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 5s = 5000ms
                                startActivity(i);
                            }
                        }, 6000);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //                  Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
//                            + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();


                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }

            }
        });
    }
}