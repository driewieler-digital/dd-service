package com.driewielerdigital.cordova.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
//import android.widget.Toast;

public class DDServiceNative extends Service {

  // timer
    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
	
		private int tick = 0;
        @Override
        public void run() {

			tick++;
            Log.d("Cordova Service Timer", "tick "+tick);

            timerHandler.postDelayed(this, 1000);
        }
    };  

  private boolean running = false;
  private String ID = "Cordova DDServiceNative>";

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    //TODO do something useful
    if ( this.running ) {
    	Log.d(this.ID, "Service onStartCommand: already running");    
    }
    else {
    	Log.d(this.ID, "Service onStartCommand: started");
	    this.running = true;    	
	  }
	  // start timer
		timerHandler.postDelayed(timerRunnable, 0);	  
	    return Service.START_STICKY;	  
	}
	
  @Override
  public IBinder onBind(Intent intent) {
  //TODO for communication return IBinder implementation
    return null;
  }
  

  
} 