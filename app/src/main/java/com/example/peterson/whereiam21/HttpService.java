package com.example.peterson.whereiam21;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.net.Proxy.Type.HTTP;

/*EXAMPLE OF POST */
//[
//        {
//        "user_id": "8888888",
//        "search": "-57,-63,-63,-64,-100,-100",
//        "date": "2020-03-21 01:31:23"
//        }
//]

public class HttpService extends AsyncTask<Void, Void, SendData> {

    private final String search;
    private final String date;
    private final Integer ra;

    public HttpService(String busca, Integer ra, String data){
        this.search = busca;
        this.date = data;
        this.ra = ra;
    }
//   @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected SendData doInBackground(Void... voids) {


        return null;
    }
}
