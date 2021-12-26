package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;

    Button btn_Doc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontroll();
        addevent();
    }
    private void addevent() {
        btn_Doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulymoManHinhDB();
            }
        });
    }

    private void xulymoManHinhDB() {
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_CONTACTS"},
                    REQUEST_SMS_ASK_PERMISSIONS);

        }else   {
            Intent intent = new Intent(MainActivity.this,DanhBa.class);
            intent.setClassName("com.hoangquangdev",
                    "com.hoangquangdev.DanhBa");
            startActivity(intent);
        }

//        Intent intent = new Intent(MainActivity.this,DanhBa.class);
////        intent.setClassName("com.hoangquangdev",
////                "com.hoangquangdev.DanhBa");
//        startActivity(intent);

    }

    private void addcontroll() {
        btn_Doc = (Button) findViewById(R.id.btn_Doc);
    }
}