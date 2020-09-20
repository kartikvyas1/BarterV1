package com.example.barterv1.splashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.barterv1.R;
import com.example.barterv1.UtilityPackage1.SharedPreference1;
import com.example.barterv1.loginActivity.SignInActivity;
import com.example.barterv1.loginActivity.SignUpActivity;

public class splashActivity extends AppCompatActivity {

    // this is how we trouble shoot

    private String TAG = "splashactivity";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_layout);
        init();//this will initialise a counter of 5 seconds pause after start screen

        // here we will print the TAG to see if this method executed
        Log.e(TAG, "splash oncreate started showing ");
    }

    public void init() {
        new Handler().postDelayed(new Runnable() { //run is the method that " executes "
            @Override
            public void run() {
                // if registered user then show home sreen
                // else show home screen

                // to check if runnable is running
                Log.e(TAG, "runnalble or counter running");
                // this is a check if the user is already registered using the userid and password
                if (SharedPreference1.getInstance().getString("UserId", "password").equalsIgnoreCase("success")) {
                    Intent intent = new Intent(splashActivity.this, SignInActivity.class);
                    startActivity(intent);

                } else {
                    // not registered so return to login screen or password incorrent
                    Intent intent = new Intent(splashActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 5000);
    }
}
