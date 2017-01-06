package com.example.apurv.navriti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OTPVerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
    }

    public void joinStream(View view) {

        //pending corrections in this part.
        String correctOTP = "428695";
        EditText editText = (EditText) findViewById(R.id.enter_otp);
        String receivedOTP = editText.getText().toString();

        if(receivedOTP.equals(correctOTP)) {

            Toast.makeText(getApplicationContext(), "Authentication Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,StreamingActivity.class);
            startActivity(intent);
        }

        else {
            Toast.makeText(getApplicationContext(), "Valid OTP not entered!!", Toast.LENGTH_SHORT).show();
        }
    }
}
