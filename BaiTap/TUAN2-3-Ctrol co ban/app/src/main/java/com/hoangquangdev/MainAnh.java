package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainAnh extends AppCompatActivity {
    ImageView imageView;
    RadioButton rbNY , rbCR;
    ImageView img;
    ImageButton imbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anh);
        addctrall();
          event();

    }

    private void addctrall() {
        imageView = (ImageView) findViewById(R.id.imageView);
        rbCR = (RadioButton) findViewById(R.id.rbCR);
        rbNY = (RadioButton) findViewById(R.id.rbNY);
        img = (ImageView) findViewById(R.id.imageView);
        imbtn = (ImageButton)findViewById(R.id.imageButton);
    }
    private void event(){
        rbNY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischeck) {
                if (ischeck){
                    imageView.setImageResource(R.drawable.img01);
                }
            }
        });
        rbCR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischeck) {
                if (ischeck){
                    imageView.setImageResource(R.drawable.img02);
                }
            }
        });
        imbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}