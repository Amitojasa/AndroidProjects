package com.example.weatherapp;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MySingleton {
    private static MySingleton myInstance;
    private RequestQueue requestQueue;


    public MySingleton(Context context){

        requestQueue = Volley.newRequestQueue(context.getApplicationContext());

    }

    public static synchronized  MySingleton getInstance(Context context){
        if(myInstance ==null){
            myInstance = new MySingleton(context);
        }
        return myInstance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
    public void addToRequestQue(Request request){
        requestQueue.add(request);
    }

}

