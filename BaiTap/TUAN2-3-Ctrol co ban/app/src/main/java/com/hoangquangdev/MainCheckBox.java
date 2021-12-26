package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainCheckBox extends AppCompatActivity {
    //Khai Báo
    Button btnQuayLai,btnChon,btnTraLoi,btnXemAnh;
    TextView txtHienThi;
    CheckBox cBThuong,cBAnh,cBQuanh,cBNhi,cBLan;
    RadioButton rbCo , rBKhong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_check_box);
        addcontroll();
        addevent();
    }

    private void addcontroll() {
        btnQuayLai = (Button) findViewById(R.id.btnQuayLai);
        btnChon = (Button) findViewById(R.id.btnChon);
        cBThuong = (CheckBox) findViewById(R.id.cBThuong);
        cBAnh = (CheckBox) findViewById(R.id.cBAnh);
        cBQuanh = (CheckBox) findViewById(R.id.cBQuanh);
        cBNhi = (CheckBox) findViewById(R.id.cBNhi);
        cBLan = (CheckBox) findViewById(R.id.cBLan);
        txtHienThi = (TextView) findViewById(R.id.txtHienThi);
        btnTraLoi = (Button) findViewById(R.id.btnTraLoi);
        rbCo = (RadioButton) findViewById(R.id.rBCo);
        rBKhong = (RadioButton) findViewById(R.id.rBkhong);
        btnXemAnh = (Button) findViewById(R.id.btnXemAnh);
    }
    private void addevent(){
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "";
                if (cBThuong.isChecked()) {
                    text += cBThuong.getText().toString() + "\n";
                }
                if (cBAnh.isChecked()) {
                    text += cBAnh.getText().toString() + "\n";
                }
                if (cBQuanh.isChecked()) {
                    text += cBQuanh.getText().toString() + "\n";
                }
                if (cBNhi.isChecked()) {
                    text += cBNhi.getText().toString() + "\n";
                }
                if (cBLan.isChecked()) {
                    text += cBLan.getText().toString() + "\n";
                }
                txtHienThi.setText(text);
            }

        });
        btnTraLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texts ="";
                if (rbCo.isChecked()){
                    texts=rbCo.getText().toString();
                }
                if (rBKhong.isChecked()){
                    texts=rBKhong.getText().toString();
                }
                Toast.makeText(MainCheckBox.this, "Bạn muốn "+texts,Toast.LENGTH_LONG).show();
            }
        });
        btnXemAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent xemAnh = new Intent(MainCheckBox.this , MainAnh.class);
                startActivity(xemAnh);
            }
        });

    }

    public void quayLai(View view) {
        Intent mh1 = new Intent(MainCheckBox.this, MainActivity.class);
        startActivity(mh1);
    }
}