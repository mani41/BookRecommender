package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.controllers.UserController;
import info.androidhive.materialdesign.model.UserModel;


/**
 * Author : Mani Shankar
 * Date : 19/08/2017
 */

public class LoginActivity extends AppCompatActivity {

    private EditText name;
    private EditText phoneNumber;
    private Button Login;
    private Button Cancel;
    private String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_info);
        setupVariables();
        UserModel userModel = UserController.getInstance().getUser();
        userModel.setUserName(name.toString());
        userModel.setUserName(phoneNumber.toString());

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(phoneNumber.getText().toString().trim().equals("")){
                    phoneNumber.setError("phone number is required");
                }
                else if (authenticateLogin(v)) {
                    Intent intent = new Intent(LoginActivity.this, LocationPermission.class);
                    startActivity(intent);
                }
            }

        });
    }


    public boolean authenticateLogin(View view) {
        if (name.getText().toString().equals("admin") && phoneNumber.getText().toString().equals("9090")) {
            Toast.makeText(getApplicationContext(), "Hello admin!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void setupVariables() {
        name = (EditText) findViewById(R.id.name);
        phoneNumber = (EditText) findViewById(R.id.phoneNum);

        Login = (Button) findViewById(R.id.loginB);
        deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}

