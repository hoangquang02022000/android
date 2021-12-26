package com.hoangquangdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCNTT, btnKTPM, btnANM;
    // tao controls de luu tru controls su dung cuoi cung
    Button lastSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        // tao su kien onlong cick va luu lai controls su dung cuoi cung
        btnANM.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                lastSelected = btnANM;
                return false;
            }
        });
        btnCNTT.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                lastSelected = btnCNTT;
                return false;
            }
        });
        btnKTPM.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                lastSelected = btnKTPM;
                return false;
            }
        });
    }

    private void addControls() {
        btnANM = findViewById(R.id.btnANM);
        btnCNTT = findViewById(R.id.btnCNTT);
        btnKTPM = findViewById(R.id.btnKTPM);
        // gan context cho tung control
        registerForContextMenu(btnANM);
        registerForContextMenu(btnCNTT);
        registerForContextMenu(btnKTPM);
    }
    // khoi tao context menu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // tao su kien chon context Menu

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.indam){
            lastSelected.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }else if (item.getItemId() == R.id.tochudo){
            lastSelected.setTextColor(Color.RED);
        }else if (item.getItemId() == R.id.xoa){
            lastSelected.setVisibility(View.INVISIBLE);
        }
        return super.onContextItemSelected(item);
    }
}