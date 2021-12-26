package com.hoangquangdev;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.metrics.Event;
import android.mtp.MtpEvent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Year;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    TextView txtHienThi,txtMauSacHT,txtMonAn,txtTheThao;
    Button btnTinhTuoi,btnMauSac,btnMonAn,btnTheThao,btnAn,btnHien,btnDoiMH;
    EditText etxtNamSinh;
    //Tạo 1 sự kiện onclick để button bắt đầu xử lý sự kiện
    View.OnClickListener sukienVarialble = null ;
    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addevents();
    }

    private void addControls() {
        txtHienThi=(TextView) findViewById(R.id.txtHienThi);
        btnTinhTuoi = (Button) findViewById(R.id.btnTinh);
        etxtNamSinh = (EditText) findViewById(R.id.etxtNamSinh);
        txtMauSacHT = (TextView) findViewById(R.id.txtMauSacHT);
        btnMauSac = (Button) findViewById(R.id.btnMauSac);


        txtMonAn = (TextView) findViewById(R.id.txtMonAn);
        btnMonAn = (Button) findViewById(R.id.btnMonAn);
        txtTheThao=(TextView) findViewById(R.id.txtTheThao);
        btnTheThao=(Button) findViewById(R.id.btnTheThao);

        btnAn =(Button) findViewById(R.id.btnAn);
        btnHien = (Button) findViewById(R.id.btnHien);
        btnDoiMH = (Button) findViewById(R.id.btnDoiMH);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void TinhTuoi(View view){
        int year = Year.now().getValue();
        int namSinh=Integer.parseInt(etxtNamSinh.getText().toString());
        txtHienThi.setText("Tuổi Của Bạn Là "+(year-namSinh));
        Toast.makeText(this,""+(year-namSinh),Toast.LENGTH_SHORT).show();
    }
    public void theThao(){
        txtTheThao.setText("Môn thể thao yêu thích : chơi gái");
    }
    public void monAn(){
        txtMonAn.setText("Món ăn yêu thích : Gái");
    }
    @RequiresApi(api = Build.VERSION_CODES.S)
    private void addevents(){
        btnMauSac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMauSacHT.setText("Màu Hồng !");
                txtMauSacHT.setTextColor(Color.parseColor("#F26398"));
            }
        });
        sukienVarialble = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btnMonAn){
                    monAn();
                }else if(view.getId()==R.id.btnTheThao){
                    theThao();
                }
            }
        };
        btnTheThao.setOnClickListener(sukienVarialble);
        btnMonAn.setOnClickListener(sukienVarialble);
        btnAn.setOnLongClickListener(this);
        btnHien.setOnClickListener(new MyEvent());
//        btnHien.setOnLongClickListener(new MyEvent());
//        btnMonAn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                txtMonAn.setText("Món ăn yêu thích : Gái");
//            }
//        });
//        btnTheThao.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                txtTheThao.setText("Môn thể thao yêu thích : chơi gái");
//            }
//        });
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId()==R.id.btnAn){
            btnAn.setVisibility(View.INVISIBLE);
        }
        return false;
    }

    public void SK_DoiMHinh(View view) {
        Button btnMoi = new androidx.appcompat.widget.AppCompatButton(MainActivity.this){
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);
                addevents();
                addControls();
                return super.performClick();
            }
        };
        btnMoi.setText("Quay Về");
        btnMoi.setHeight(400);
        btnMoi.setWidth(200);
        setContentView(btnMoi);
    }


    private class MyEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnHien){
                btnAn.setVisibility(View.VISIBLE);
            }
        }
    }
}