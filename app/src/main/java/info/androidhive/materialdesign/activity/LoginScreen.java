package info.androidhive.materialdesign.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import info.androidhive.materialdesign.R;
/**
 * Created by Mani Shankar on 26-08-2017.
 */
public class LoginScreen extends AppCompatActivity {

    private Button loginNowButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        loginNowButton = (Button) findViewById(R.id.loginNowButton);
        loginNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(LoginScreen.this, LoginActivity.class);
                    startActivity(intent);
            }
        });
    }
}
