package com.example.apurv.navriti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by apurv on 1/3/17.
 */

public class SplashActivity extends Activity{

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       // TODO Auto-generated method stub
       super.onCreate(savedInstanceState);
       setContentView(R.layout.splash);

       Thread timerThread = new Thread(){
           public void run(){
               try{
                   sleep(3000);
               }catch(InterruptedException e){
                   e.printStackTrace();
               }finally{
                   Intent intent = new Intent(SplashActivity.this,UserSelectionActivity.class);
                   startActivity(intent);
               }
           }
       };
       timerThread.start();
   }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
