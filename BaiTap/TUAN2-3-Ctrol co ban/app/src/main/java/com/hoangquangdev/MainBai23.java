package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainBai23 extends AppCompatActivity {
    Button btnAppDanhBa,btn_AppDanSo, getBtn_AppTiGia , btn_qualynhanvien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai23);
        addctrol();
        addevent();
    }


    private void addctrol() {
        btnAppDanhBa = (Button) findViewById(R.id.btnAppDanhBa);
        btn_AppDanSo = (Button) findViewById(R.id.btn_AppDanSo);
        getBtn_AppTiGia = (Button) findViewById(R.id.btn_appTiGia);
        btn_qualynhanvien = (Button) findViewById(R.id.btn_appQuanLyNhanVien);
    }
    private void addevent() {
        btnAppDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appDB = new Intent(MainBai23.this,MainAppDanhBa.class);
                startActivity(appDB);
            }
        });
        btn_AppDanSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appDS = new Intent(MainBai23.this,MainAppDanSo.class);
                startActivity(appDS);
            }
        });
        getBtn_AppTiGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appTG = new Intent(MainBai23.this,MainAppTiGia.class);
                startActivity(appTG);
            }
        });
        btn_qualynhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appQLNV = new Intent(MainBai23.this,MainAppNhanVien.class);
                startActivity(appQLNV);
            }
        });
    }

}