package info.androidhive.materialdesign.activity;


import android.Manifest;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.MarkerOptions;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.utilities.GPSTracker;

/**
 * Created by anushah on 8/19/2017.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback{
    Double latitude;
    Double longitude;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment map = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        /*locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, this );
        }*/
        map.getMapAsync(this);


        Button button = (Button) findViewById(R.id.getDirection);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateUsingGoogleMap();
            }
        });

    }

    public void navigateUsingGoogleMap(){
        String destinationAddress = Double.toString(latitude) + ',' + Double.toString(longitude);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr="+destinationAddress));
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent intent = getIntent();
        latitude = intent.getDoubleExtra("latitude",0.0);
        longitude = intent.getDoubleExtra("longitude",0.0);
        LatLng location = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(location)
                .title("GOOGLE MAPS!!"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 14.0f));
    }


}
