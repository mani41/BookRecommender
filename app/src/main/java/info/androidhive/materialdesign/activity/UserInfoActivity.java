package info.androidhive.materialdesign.activity;


import android.content.Intent;

import android.location.Location;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;
import java.util.Random;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.controllers.UserController;
import info.androidhive.materialdesign.model.UserModel;
import info.androidhive.materialdesign.utilities.GPSTracker;

/**
 * Created by anushah on 8/19/2017.
 */

public class UserInfoActivity extends AppCompatActivity {

    View view;

    //int rand = new Random().nextInt(getUserList().size());;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo_view);
        populateUser();

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.mapButton);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                GPSTracker gps = new GPSTracker(getApplicationContext());
                double curlatitude = gps.getLatitude();
                double curlongitude = gps.getLongitude();

                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                //intent.putExtra("latitude",getUserList().get(rand).getLatitude());
                //intent.putExtra("longitude",getUserList().get(rand).getLongitude());
                intent.putExtra("curlatitude",curlatitude);
                intent.putExtra("curlongitude",curlongitude);

                startActivity(intent);

            }
        });

    }

    public void populateUser(){
        TextView setUsername = (TextView)findViewById(R.id.username);
        //setUsername.setText(getUserList().get(rand).getUserName());
    }
}