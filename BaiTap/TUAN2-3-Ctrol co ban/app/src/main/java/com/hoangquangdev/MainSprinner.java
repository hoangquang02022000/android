package com.hoangquangdev;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainSprinner extends AppCompatActivity {
    EditText txt_tenNV,txt_songayCT;
    Spinner sp_thuCT;
    Button btnXacNhan;
    ArrayList<String>listthu;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sprinner);
        addcontroll(); 
        addevent();
    }
    private void addcontroll() {
    }
    private void addevent() {
        listthu = new ArrayList<>();
        String[] arrthu = getResources().getStringArray(R.array.arrThu);
        for (String item : arrthu){
            listthu.add(item);
        }
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,listthu);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp_thuCT.setAdapter(adapter);
        sp_thuCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainSprinner.this,listthu.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Spenner");
        return super.onCreateOptionsMenu(menu);
    }
}