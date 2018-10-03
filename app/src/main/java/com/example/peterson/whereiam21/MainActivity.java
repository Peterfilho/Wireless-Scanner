package com.example.peterson.whereiam21;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;
    private ListView listView;
    private Button buttonScan;
    private int size = 0;
    private List<ScanResult> results;
    private ArrayList<String> arraylist = new ArrayList<>();
    private ArrayAdapter adapter;
   private BroadcastReceiver wifiReceiver;

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

        listView = findViewById(R.id.wifiList);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if (!wifiManager.isWifiEnabled()){
            Toast.makeText(this, "O Wifi está desligado, ative e tente novamente!", Toast.LENGTH_LONG).show();
            wifiManager.setWifiEnabled(true);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraylist);
        listView.setAdapter(adapter);




        scanWifi();

    }

    private void scanWifi () {
        arraylist.clear();
        registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

            wifiManager.startScan();

        Toast.makeText(this, "Procurando redes WiFi ..", Toast.LENGTH_SHORT).show();
        results = wifiManager.getScanResults();

        for (ScanResult scanResult : results) {

            Log.d("Teste", scanResult.SSID);
            arraylist.add(
                                scanResult.SSID +
                    "dBm:  " + scanResult.level +
                    "MAC: " + scanResult.BSSID +
                    "Chave: " + scanResult.capabilities);
            adapter.notifyDataSetChanged();
        }

    }


}





