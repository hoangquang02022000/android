package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputEmail , inputPassword;
    Button btnlogin , btnthoat;
    CheckBox checkSave;
    String luuthongtin = "tk_mk login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrol();
        addevent();
    }

    private void addevent() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(1);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(luuthongtin,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("UserName",inputEmail.getText().toString());
                editor.putString("PassWord",inputPassword.getText().toString());
                editor.putBoolean("Save",checkSave.isChecked());
                editor.commit();
                Toast.makeText(MainActivity.this, "Đã Đăng Nhập", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addcontrol() {
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnthoat = (Button) findViewById(R.id.btnthoat);
        checkSave = (CheckBox) findViewById(R.id.checkSave);


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(luuthongtin,MODE_PRIVATE);
        String username = sharedPreferences.getString("UserName","");
        String pass = sharedPreferences.getString("PassWord","");
        boolean save = sharedPreferences.getBoolean("Save",false);
        if (save==true){
            inputEmail.setText(username);
            inputPassword.setText(pass);
        }
    }
}