package com.example.peterson.whereiam21;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void, Void, SendData> {

    private final String search;
    private final String date;
    private final String ra;

    private String jsonInputString = "{'user_id':'0000000', 'search':'-100,-67,-63,-49,-53,-48', 'date':'2020-03-21 16:00:00'}";

    public HttpService(String busca, String ra, String data){
        this.search = busca;
        this.date = data;
        this.ra = ra;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected SendData doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        if(this.search != null && this.date != null && this.ra != null){
            try {
                URL url = new URL("http://127.0.0.1:5000/api/v1/resources/positions/app");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");

                connection.setRequestProperty("Content-type", "application/json; utf-8");
                connection.setRequestProperty("Accept", "application/json");

                connection.setDoOutput(true);

                //connection.setConnectTimeout(5000);
                //connection.connect();

                try(OutputStream os = connection.getOutputStream()){
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int code = connection.getResponseCode();
                System.out.println(code);

                try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))){
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println(response.toString());
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
