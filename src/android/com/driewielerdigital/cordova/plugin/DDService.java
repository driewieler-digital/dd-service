package com.driewielerdigital.cordova.plugin;

    import org.apache.cordova.CordovaPlugin;
    import org.apache.cordova.CallbackContext;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;
	import android.util.Log;    

// service stuff.
	import android.content.Context;
	import android.app.Service;
	import android.content.Intent;
	import android.os.IBinder;
	import android.util.Log;

    /**
     * This class echoes a string called from JavaScript.
     */
    public class DDService extends CordovaPlugin {



        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        	Log.d("Cordova", "Initialized");
            if (action.equals("echo")) {
                String message = args.getString(0);
                this.echo(message, callbackContext);
                Log.d("Cordova", "Executing...");
                
	            Context context = cordova.getActivity().getApplicationContext();                             
                
				// use this to start and trigger a service
				Intent i= new Intent(context, DDServiceNative.class);
				// potentially add data to the intent
				i.putExtra("KEY1", "Value to be used by the service");
				context.startService(i);                 
                
                return true;
            }
            return false;
        }

        private void echo(String message, CallbackContext callbackContext) {
            if (message != null && message.length() > 0) {
                callbackContext.success(message);
            } else {
                callbackContext.error("Expected one non-empty string argument.");
            }
        }
        

    }