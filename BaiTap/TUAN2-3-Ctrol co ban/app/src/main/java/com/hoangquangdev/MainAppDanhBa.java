package com.hoangquangdev;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.DanhBaadapter;
import model.DanhBa;

public class MainAppDanhBa extends AppCompatActivity {
    ListView listviewDanhBa;
    ArrayList<DanhBa>dsDanhBa;
    DanhBaadapter danhBaadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);
        addvtroll();
    }

    private void addvtroll() {
        listviewDanhBa = findViewById(R.id.listview);
        dsDanhBa = new ArrayList<>();
        dsDanhBa.add(new DanhBa(01,"Nguyễn Hoàng Quang","0961379812"));
        dsDanhBa.add(new DanhBa(02,"Hoàng Mạnh Hùng","0961379812"));
        dsDanhBa.add(new DanhBa(03,"Lê Văn Thái","0961379812"));
        dsDanhBa.add(new DanhBa(04,"Phạm Thành Thắng","0961379812"));
        danhBaadapter = new DanhBaadapter(MainAppDanhBa.this,R.layout.view_danhba,dsDanhBa);
        listviewDanhBa.setAdapter(danhBaadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Danh Bạ");
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}