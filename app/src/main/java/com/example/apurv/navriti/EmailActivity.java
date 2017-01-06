package com.example.apurv.navriti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.net.Uri;
import android.util.Log;
import java.util.Arrays;
import java.util.List;

public class EmailActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.apurv.navriti.MESSAGE";

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        Intent intent = getIntent();
    }

    public void publishStream(View view){

        Intent intent = new Intent(this,StreamingActivity.class);
        EditText editText = (EditText) findViewById(R.id.enter_email);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendEmail(View view) {


        EditText editText = (EditText) findViewById(R.id.enter_email);
        String to = editText.getText().toString();
        String subject = "Hello from Navriti!!";
        String body = "Thank you for using Navriti app. Your OTP is 428695.";

        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, body);
        email.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        email.setType("message/rfc822");
        //email.setType("*/*");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

    }
}
