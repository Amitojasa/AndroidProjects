package com.example.apihandler;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static VolleySingleton myInstance;
    private RequestQueue requestQueue;


    public VolleySingleton(Context context){

        requestQueue = Volley.newRequestQueue(context.getApplicationContext());

    }

    public static synchronized  VolleySingleton getInstance(Context context){
        if(myInstance ==null){
            myInstance = new VolleySingleton(context);
        }
        return myInstance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
