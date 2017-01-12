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

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String EXTRA_MESSAGE = "com.example.apurv.navriti.MESSAGE";

    //Declaring EditText
    private EditText editTextEmail;

    //Send button
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        editTextEmail = (EditText) findViewById(R.id.enter_email);

        buttonSend = (Button) findViewById(R.id.buttonPanel);

        buttonSend.setOnClickListener(this);

        Intent intent = getIntent();
//        send = (Button) findViewById(R.id.buttonPanel);
//        send.setOnClickListener(new View());
    }

    public void publishStream(View view){

        Intent intent = new Intent(this,StreamingActivity.class);
        EditText editText = (EditText) findViewById(R.id.enter_email);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendEmail() {

//        Given below is the code to send email via an email client.
//        **************************************************************
//
//        EditText editText = (EditText) findViewById(R.id.enter_email);
//        String to = editText.getText().toString();
//        String subject = "Streaming Code";
//        String body = "Thank you for using Navriti app. Your secure code to join my stream is 428695. You can download the app via https://drive.google.com/open?id=0B5C6c1293LKSWE9OdXlMZFNlUm8.";
//
//        Intent email = new Intent(Intent.ACTION_SEND);
//        email.setData(Uri.parse("mailto:"));
//        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
//        email.putExtra(Intent.EXTRA_SUBJECT, subject);
//        email.putExtra(Intent.EXTRA_TEXT, body);
//        email.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        email.setType("message/rfc822");
//
//        startActivity(Intent.createChooser(email, "Choose an Email client :"));
//
//        **************************************************************


        String email = editTextEmail.getText().toString().trim();
        String subject = "Hello from Navriti";
        String message = "Thank you for using Navriti app.Your passcode to join the stream is:" +
                "\n\n" +
                "*428695*" +
                "\n\n" +
                "Cheers!!";

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
