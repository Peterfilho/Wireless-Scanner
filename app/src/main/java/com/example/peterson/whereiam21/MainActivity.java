package com.example.peterson.whereiam21;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;
    private ListView listView;
    private Button buttonScan;
    private int size = 0;
    private List<ScanResult> results;
    private ArrayList<String> arraylist = new ArrayList<>();
    private ArrayAdapter adapter;
    private BroadcastReceiver wifiReceiver;
    private  Integer sleepTime = 5;
    private Integer scanTimes = 4;
    private String hora;
    private String data;
    private String datetime;
    private String tsi; //2a não deixa criar
    private String c7;
    private String f5;
    private String d0;
    private String f6;
    private String c8;

    private ArrayList<ScanSignal> referenceSignals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonScan = findViewById(R.id.scanBtn);
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanWifi();
            }
        });
        EditText editText = findViewById(R.id.ra);

        Switch aSwitch = findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    try {
                        showMessage();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


//        editText.setText("9988770");
//        To not auto open keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        listView = findViewById(R.id.wifiList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraylist);
        listView.setAdapter(adapter);

    }

    private void scanWifi () {

        Toast.makeText(this, "Procurando redes ..", Toast.LENGTH_SHORT).show();

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        LocationManager service = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);

//        boolean gpsEnabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
        /* VERIFICA SE O GPS ESTÁ LIGADO */
//        if (!gpsEnabled) {
//            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//            startActivity(intent);
//        }

        arraylist.clear();

        HashMap<String, ArrayList<Integer>> result = new HashMap<String, ArrayList<Integer>>();
        HashMap<String, Float> resultMedia = new HashMap<String, Float>();

        for (int scanIndex = 0; scanIndex < scanTimes; scanIndex++) {
            registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

            wifiManager.startScan();

            results = wifiManager.getScanResults();

            //WifiInfo wifiInfo = wifiManager.getConnectionInfo();

            Log.d("DEBUG", results.size() + "");

            for (ScanResult scanResult : results) {

                String tokens[] = scanResult.BSSID.split(":");
                String finalMac = tokens[tokens.length - 1];

                //String finalMac = scanResult.BSSID;

                if (!result.containsKey(finalMac)) {
                    result.put(finalMac, new ArrayList<Integer>());
                    resultMedia.put(finalMac, 0.f);
                }

                result.get(finalMac).add(scanResult.level);
                resultMedia.put(finalMac, resultMedia.get(finalMac) + scanResult.level);
                Log.d("DEBUG", "MAC: " + finalMac + " e dBm:  " + scanResult.level);
            }

            try {
                TimeUnit.SECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (String hashKey : resultMedia.keySet())
            resultMedia.put(hashKey, resultMedia.get(hashKey) / scanTimes);

        ScanSignal currentSignal = new ScanSignal();


        Log.d("DEBUG", currentSignal.toString());


//        for (String hashKey : result.keySet()) {
//            Log.d("DEBUG", "Hashmap key:" + hashKey);
//
//            int i = 0;
//            for (Integer level : result.get(hashKey)) {
//                Log.d("DEBUG", "   Level (scan " + (++i) + ") : " + level);
//            }
//            Log.d("DEBUG", "   Média: " + resultMedia.get(hashKey));
//
//            switch (hashKey) {
//                case "b2":
//                    Log.d("DEBUG", "entrando no first case");
//                    tsi = resultMedia.get(hashKey).toString();
//                    break;
//
//                case "ff":
//
//                    Log.d("DEBUG", "entrando no second case");
//                    c7 = resultMedia.get(hashKey).toString();
//                    break;
//
//                case "f5":
//
//                    Log.d("DEBUG", "entrando no third case");
//                    f5 = resultMedia.get(hashKey).toString();
//                    break;
//
//                case "d0":
//
//                    Log.d("DEBUG", "entrando no fourth case");
//                    d0 = resultMedia.get(hashKey).toString();
//                    break;
//
//                case "f6":
//                    f6 = resultMedia.get(hashKey).toString();
//                    break;
//
//                case "c8":
//                    c8 = resultMedia.get(hashKey).toString();
//                    break;
//
//                case "le":
//                    tsi = resultMedia.get(hashKey).toString();
   //         }
 //       }



        /*  EXIBINDO REDES DISPONÍVEIS EM UMA LISTVIEW DO APP */
        for (ScanResult scanResult : results) {

            arraylist.add(
                    scanResult.SSID +
                            "\n média do sinal dBm:\n  " + scanResult.level +
                            "\n MAC: \n" + scanResult.BSSID);
                            //"\n Chave: " + scanResult.capabilities);
            adapter.notifyDataSetChanged();

        }
    }

    public static final String DATE_FORMAT_1 = "hh:mm a";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd";

    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_1);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_2);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    private void showMessage() throws ExecutionException, InterruptedException {
        hora = getCurrentTime();
        data = getCurrentDate();
        datetime = (data+" "+hora);
        datetime = datetime.substring(0,datetime.length() -3);
        Integer ra = 9988770;
        String search = "-100,-67,-63,-49,-53,-48";
        Toast.makeText(this, "Localização Ativada! "+datetime, Toast.LENGTH_SHORT).show();
        Log.d("DEBUG", "Busca: "+search+", ra: "+ra+", Data: "+datetime);
        sendData(search, ra, datetime);
    }

    private void sendData(final String busca, final Integer user_id, final String data) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.0.20:5000/api/v1/resources/positions/app";

        JSONObject js = new JSONObject();
        try {
            js.put("user_id", user_id);
            js.put("search", busca);
            js.put("date", data);
            Log.d("DEBUG json: ",""+js);
        }catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url,js,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("DEBUG: ", response.toString());

                        Log.d("DEBUG: ", "" + response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error: ", "" + error.getMessage());
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        queue.add(jsonObjectRequest);
    }
}