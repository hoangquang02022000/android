package com.hoangquangdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text_View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_View = findViewById(R.id.text_View);
    }
    // Khoi tao menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // Tao su kien khi click item option menu to mau Textview

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.tomauxanh){
            text_View.setBackgroundResource(R.color.purple_500);
        }else if (item.getItemId()==R.id.tomauxanh2){
            text_View.setBackgroundResource(R.color.purple_700);
        }else if (item.getItemId()==R.id.tomauxanh3){
            text_View.setBackgroundResource(R.color.teal_700);
        }
        return super.onOptionsItemSelected(item);
    }
}