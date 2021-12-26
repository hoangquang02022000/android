package com.hoangquangdev;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.Person_Adapter;
import model.Nation;

public class MainAppDanSo extends AppCompatActivity {
    ListView listviewappdanso;
    ArrayList<Nation> dsnation;
    Person_Adapter dsPersom_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);
        addControll();
    }

    private void addControll() {
        listviewappdanso = findViewById(R.id.listview);
        dsnation = new ArrayList<>();
        dsnation.add(new Nation(R.drawable.vietnam,"Việt Nam",97702965));
        dsnation.add(new Nation(R.drawable.thailand,"Thailand",63389730));
        dsnation.add(new Nation(R.drawable.singapore,"Singapore",4839400));
        dsPersom_Adapter = new Person_Adapter(
                MainAppDanSo.this,R.layout.view_nation ,dsnation
        );
        listviewappdanso.setAdapter(dsPersom_Adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle("Các Quốc Gia");
                getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

}