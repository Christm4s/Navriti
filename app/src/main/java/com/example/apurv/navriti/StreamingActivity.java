package com.example.apurv.navriti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.media.MediaRecorder;


import android.content.res.Resources;

import android.view.View;
import android.widget.LinearLayout;
import android.util.Log;
import android.widget.Toast;

import com.opentok.android.Publisher;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;
import com.opentok.android.Stream;
import com.opentok.android.Subscriber;
import com.opentok.android.SubscriberKit;
import com.opentok.android.OpentokError;

import java.io.IOException;


public class StreamingActivity extends AppCompatActivity implements Session.SessionListener,
        Publisher.PublisherListener, Subscriber.SubscriberListener,
        Subscriber.VideoListener {

    public static final String API_KEY = "45743682"; //Put your API Key here.
    public static final String SESSION_ID = "2_MX40NTc0MzY4Mn5-MTQ4MzUyNDI3OTU3OX5obi9tWGNac0w3ek1wMnFzNHRNcE1lMnh-fg";
    public static final String TOKEN = "T1==cGFydG5lcl9pZD00NTc0MzY4MiZzaWc9ZDdmYmQwMzVkNWVkYmVjYWI2NTdmYWE1YjdlZDViZjljYTA0MTVmZjpzZXNzaW9uX2lkPTJfTVg0ME5UYzBNelk0TW41LU1UUTRNelV5TkRJM09UVTNPWDVvYmk5dFdHTmFjMHczZWsxd01uRnpOSFJOY0UxbE1uaC1mZyZjcmVhdGVfdGltZT0xNDgzNTI0MzA0Jm5vbmNlPTAuNjc4MTg1ODk0ODEwNzIwNCZyb2xlPXB1Ymxpc2hlciZleHBpcmVfdGltZT0xNDg2MTE2MzAz";

    public static final String LOGTAG = "MainActivity.class.getName()";

    private LinearLayout publisherView;
    private LinearLayout.LayoutParams publisherParams;
    private LinearLayout subscriberView;
    private LinearLayout.LayoutParams subscriberParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(LOGTAG, "call to onCreate");
        super.onCreate(savedInstanceState);

        //Intent intent = getIntent();

        LinearLayout parentLayout = new LinearLayout(this);
        setContentView(parentLayout);

        Toast.makeText(getApplicationContext(), "Starting the Stream!!", Toast.LENGTH_SHORT).show();

        //Intent intent = getIntent();
       // String message = intent.getStringExtra(EmailActivity.EXTRA_MESSAGE);

        subscriberView = new LinearLayout(this);
        subscriberParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        subscriberParams.weight = 0.5f;
        subscriberView.setLayoutParams(subscriberParams);


        publisherView = new LinearLayout(this);
        publisherParams = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        publisherParams.weight = 0.5f;
        publisherView.setLayoutParams(publisherParams);


        parentLayout.setWeightSum(1f);
        parentLayout.addView(publisherView);
        parentLayout.addView(subscriberView);


        Session session = new Session(StreamingActivity.this, API_KEY, SESSION_ID);
        session.setSessionListener(this);
        session.connect(TOKEN);

    }

    @Override
    public void onConnected(Session session) {
        Log.e(LOGTAG, "call to onConnected of the SessionListener");
        Publisher publisher = new Publisher(StreamingActivity.this);
        publisher.setPublisherListener(this);
        publisherView.addView(publisher.getView(), publisherParams);
        session.publish(publisher);
    }

    @Override
    public void onStreamReceived(Session session, Stream stream) {
        Log.e(LOGTAG, "call to onStreamReceived");
        Toast.makeText(getApplicationContext(), "A new member has joined!!", Toast.LENGTH_SHORT).show();
        Subscriber subscriber = new Subscriber(StreamingActivity.this, stream);
        subscriber.setVideoListener(this);
        session.subscribe(subscriber);
        subscriberView.addView(subscriber.getView(), subscriberParams);
    }

    @Override
    public void onDisconnected(Session session) {
        Log.e(LOGTAG, "call to onDisconnected of the SessionListener");
    }

    @Override
    public void onStreamDropped(Session session, Stream stream) {
        Log.e(LOGTAG, "call to onStreamDropped of the SessionListener");
    }

    @Override
    public void onError(Session session, OpentokError error) {
        Log.e(LOGTAG, "SessionListener error: " + error.getMessage());
    }

    @Override
    public void onStreamCreated(PublisherKit publisher, Stream stream) {
        Log.e(LOGTAG, "call to onStreamCreated of the PublisherListener");
    }

    @Override
    public void onStreamDestroyed(PublisherKit publisher, Stream stream) {
        Log.e(LOGTAG, "call to onStreamDestroyed of the PublisherListener");
    }

    @Override
    public void onError(PublisherKit publisher, OpentokError error) {
        Log.e(LOGTAG, "PublisherListener error: " + error.getMessage());
    }

    @Override
    public void onConnected(SubscriberKit subscriber) {
        Log.e(LOGTAG, "call to onConnected of the SubscriberListener");
    }

    @Override
    public void onDisconnected(SubscriberKit subscriber) {
        Log.e(LOGTAG, "call to onDisconnected of the SubscriberListener");
    }

    @Override
    public void onError(SubscriberKit subscriber, OpentokError error) {
        Log.e(LOGTAG, "SubscriberListener error: " + error.getMessage());
    }

    @Override
    public void onVideoDataReceived(SubscriberKit subscriber) {
        Log.e(LOGTAG, "call to onVideoDataReceived of the VideoListener");
    }

    @Override
    public void onVideoDisabled(SubscriberKit subscriber, java.lang.String reason) {
        Log.e(LOGTAG, "call to onVideoDisabled of the VideoListener");
    }

    @Override
    public void onVideoEnabled(SubscriberKit subscriber, java.lang.String reason) {
        Log.e(LOGTAG, "call to onVideoEnabled of the ViT1==cGFydG5lcl9pZD00NTc0MzY4MiZzaWc9ZDdmYmQwMzVkNWVkYmVjYWI2NTdmYWE1YjdlZDViZjljYTA0MTVmZjpzZXNzaW9uX2lkPTJfTVg0ME5UYzBNelk0TW41LU1UUTRNelV5TkRJM09UVTNPWDVvYmk5dFdHTmFjMHczZWsxd01uRnpOSFJOY0UxbE1uaC1mZyZjcmVhdGVfdGltZT0xNDgzNTI0MzA0Jm5vbmNlPTAuNjc4MTg1ODk0ODEwNzIwNCZyb2xlPXB1Ymxpc2hlciZleHBpcmVfdGltZT0xNDg2MTE2MzAzdeoListener");
    }

    @Override
    public void onVideoDisableWarning(SubscriberKit subscriber) {
        Log.e(LOGTAG, "call to onVideoDisableWarning of the VideoListener");
    }

    @Override
    public void onVideoDisableWarningLifted(SubscriberKit subscriber) {
        Log.e(LOGTAG, "call to onVideoDisableWarning of the VideoListener");
    }

    public void recordStream(View view) {

        MediaRecorder recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        //recorder.setOutputFile(PATH_NAME);
        try {
            recorder.prepare();
        }
        catch(IOException e) {
            Toast.makeText(getApplicationContext(), "IOException on prepare()", Toast.LENGTH_SHORT).show();
        }
        recorder.start();   // Recording is now started
        //...
        recorder.stop();
        recorder.reset();   // You can reuse the object by going back to setAudioSource() step
        recorder.release(); // Now the object cannot be reused
    }
}


