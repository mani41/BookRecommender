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
import info.androidhive.materialdesign.model.BookUserMapper;
import info.androidhive.materialdesign.model.UserModel;
import info.androidhive.materialdesign.utilities.GPSTracker;

/**
 * Created by anushah on 8/19/2017.
 */

public class UserInfoActivity extends AppCompatActivity {

    View view;
    BookUserMapper bookUserMapper;
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
                intent.putExtra("latitude",bookUserMapper.getUser().getLatitude());
                intent.putExtra("longitude",bookUserMapper.getUser().getLongitude());
                intent.putExtra("curlatitude",curlatitude);
                intent.putExtra("curlongitude",curlongitude);

                startActivity(intent);

            }
        });

    }

    public void populateUser(){
        Intent intent = getIntent();
        int cardPosition = intent.getIntExtra("cardPosition",0);
        bookUserMapper = UserController.getInstance().getMatchBookResults().get(cardPosition);

        TextView setUsername = (TextView)findViewById(R.id.username);
        setUsername.setText(bookUserMapper.getUser().getUserName());

        TextView setBookName = (TextView)findViewById(R.id.bookname);
        setBookName.setText(bookUserMapper.getBookBorrow().getTitle());

        // need to get author info here
        TextView setAuthor = (TextView) findViewById(R.id.author);
        setAuthor.setText(setAuthor.getText().toString() + bookUserMapper.getBookBorrow().getIsbn());

        TextView setExchange = (TextView) findViewById(R.id.exchange);
        setExchange.setText(bookUserMapper.getBookLend().getTitle());

        TextView setPurchaseDate = (TextView) findViewById(R.id.puchaseyear);
        setPurchaseDate.setText(bookUserMapper.getUser().getPhoneNumber());

        TextView setGoToMap = (TextView) findViewById(R.id.goToMap);
        setGoToMap.setText(Double.toString(bookUserMapper.getDistance()) + " km away");
    }
}
