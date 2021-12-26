package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button btnCheckBox,btnBai23,btn_bai24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addctroll();
        addevent();

    }

    private void addevent() {
        btnBai23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bai23 = new Intent(MainActivity.this,MainBai23.class);
                startActivity(bai23);
            }
        });
//        btn_bai24.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent bai24 = new Intent(MainActivity.this,MainBai24.class);
//                startActivity(bai24);
//            }
//        });
        btn_bai24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bai24 = new Intent(MainActivity.this,MainBai24.class);
                startActivity(bai24);
            }
        });
    }

    protected void addctroll(){
        btnCheckBox =(Button) findViewById(R.id.btnCheckBox);
        btnBai23 = (Button) findViewById(R.id.btnBai23);
        btn_bai24 =(Button) findViewById(R.id.btn_Bai24);
    }
    public void checBox(View v){
        Intent checbox = new Intent(MainActivity.this, MainCheckBox.class);
        startActivity(checbox);
    }


}