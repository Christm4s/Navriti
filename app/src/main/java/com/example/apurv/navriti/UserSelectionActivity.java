package com.example.apurv.navriti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserSelectionActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "com.ex"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);
    }

    public void proceedToPublish(View view){

        Intent intent = new Intent(this,EmailActivity.class);
        startActivity(intent);
    }

    public void proceedToVerify(View view) {

        Intent intent = new Intent(this,OTPVerificationActivity.class);
        startActivity(intent);
    }
}
