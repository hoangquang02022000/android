package com.hoangquangdev;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import adapter.TiGia_Adapter;
import model.TiGia;

public class MainAppTiGia extends AppCompatActivity {
    ListView lvtiGia;
    ArrayList<TiGia> dstiGia;
    TiGia_Adapter tiGia_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);
        addcotroll();
    }

    private void addcotroll() {
        lvtiGia = findViewById(R.id.listview);

        dstiGia = new ArrayList<>();
        dstiGia.add(new TiGia("USD",R.drawable.usd,2263000,2286000,11111,222222));
        dstiGia.add(new TiGia("EUR",R.drawable.eur,2592943,2727892,11111,222222));
        dstiGia.add(new TiGia("JPY",R.drawable.jpy,20200,	21369,11111,222222));
        dstiGia.add(new TiGia("KRW",R.drawable.krw,1661,	2022,11111,222222));
        dstiGia.add(new TiGia("SGD",R.drawable.sgd,1638217,1706663,11111,222222));

        tiGia_adapter = new TiGia_Adapter(
                MainAppTiGia.this,R.layout.view_tygiangoaite,dstiGia
        );
        lvtiGia.setAdapter(tiGia_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tỉ Giá");
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
