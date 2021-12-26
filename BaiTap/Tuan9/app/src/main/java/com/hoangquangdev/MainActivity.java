package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

    }
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                    context.CONNECTIVITY_SERVICE
            );
            if (connectivityManager.getActiveNetworkInfo()!=null){
                //Có wifi hiện thị button
                if (button!=null){
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Có internet", Toast.LENGTH_SHORT).show();
                }
            }else{
                //Không có wifi ẩn hiện thị button
                if (button!=null){
                    button.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Không có internet", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };


    //Đăng kí BroadcastReceiver

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver,intentFilter);
    }
    //Hủy đăng kí BroadcastReceiver

    @Override
    protected void onPause() {
        super.onPause();
        if (receiver!=null){
            unregisterReceiver(receiver);
        }
    }
}