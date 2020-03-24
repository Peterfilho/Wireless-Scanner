package com.example.peterson.whereiam21;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
//            RequestQueue queue = Volley.newRequestQueue();
//            String url ="http://192.168.0.20:5000/api/v1/resources/positions/app";
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            String resposta = (response);
//                            Log.d("DEBUG Resposta:", ""+resposta);
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    String resposta_erro = (error.getMessage());
//                    Log.d("DEBUG resposta_erro: ", ""+resposta_erro);
//                }
//            }){
//                protected Map<String, String> getParams() {
//                    Map<String, String> params = new HashMap<>();
//                    params.put("user_id", ra.toString());
//                    params.put("search", search);
//                    params.put("date", date);
//                    Log.d("DEBUG Env: ",""+params);
//                    return params;
//                }
//            };
//            queue.add(stringRequest);


//            try {
//                URL url = new URL("http://192.168.0.20:5000/api/v1/resources/positions/app");
//
//                HttpURLConnection con = (HttpURLConnection)url.openConnection();
//                con.setRequestMethod("POST");
//
//                con.setRequestProperty("Content-Type", "application/json; utf-8");
//                con.setRequestProperty("Accept", "application/json");
//
//                con.setDoOutput(true);
//
////                connection.setConnectTimeout(5000);
////                connection.connect();
////                JSONObject postData = new JSONObject();
////                postData.put("user_id", this.ra);
////                postData.put("search", this.search);
////                postData.put("date", this.date);
////                Log.d("DEBUG postData", ""+postData);
//
//                String jsonInputString = "{\"user_id\": \""+this.ra+"\", \"search\":\""+this.search+"\", \"date\":\""+this.date+"\"}";
//
//                Log.d("DEBUG Json", "{\"user_id\": \""+this.ra+"\", \"search\":\""+this.search+"\", \"date\":\""+this.date+"\"}");
//                try(OutputStream os = con.getOutputStream()){
//                    byte[] input = jsonInputString.getBytes("utf-8");
//                    os.write(input, 0, input.length);
//                }
//
//                int code = con.getResponseCode();
//                System.out.println(code);
//
//                try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
//                    StringBuilder response = new StringBuilder();
//                    String responseLine = null;
//                    while ((responseLine = br.readLine()) != null) {
//                        response.append(responseLine.trim());
//                    }
//                    Log.d("DEBUG response",""+response.toString());
//                }
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            /*OUTRO EXEMPLO*/



//            Thread t = new Thread() {
//
//                public void run() {
//                    Looper.prepare(); //For Preparing Message Pool for the child Thread
//                    HttpClient client = new DefaultHttpClient();
//                    HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
//                    HttpResponse response;
//                    JSONObject json = new JSONObject();
//
//                    try {
//                        HttpPost post = new HttpPost(URL);
//                        json.put("email", email);
//                        json.put("password", pwd);
//                        StringEntity se = new StringEntity( json.toString());
//                        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//                        post.setEntity(se);
//                        response = client.execute(post);
//
//                        /*Checking response */
//                        if(response!=null){
//                            InputStream in = response.getEntity().getContent(); //Get the data in the entity
//                        }
//
//                    } catch(Exception e) {
//                        e.printStackTrace();
//                        createDialog("Error", "Cannot Estabilish Connection");
//                    }
//
//                    Looper.loop(); //Loop in the message queue
//                }
//            };
//
//            t.start();

            //String jsonInputString = "{\"user_id\":\"9988776\", \"search\":\"-100,-67,-63,-49,-53,-48\", \"date\":\"2020-03-21 16:00:00\"}";

        return null;
    }
}
