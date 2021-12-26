package com.hoangquangdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class   MainActivity extends AppCompatActivity {
    TextView txt_percent;
    EditText etxt_soButton;
    Button btn_veButton;
    ProgressBar progressBar;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addctroll();
        addevent();
    }

    private void addevent() {
        btn_veButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(etxt_soButton.getText().toString());
                ButtonTask buttonTask = new  ButtonTask();
                buttonTask.execute(number);
            }
        });
    }

    private void addctroll() {
        txt_percent = findViewById(R.id.txt_perrcent);
        etxt_soButton = findViewById(R.id.etxt_soButton);
        btn_veButton = findViewById(R.id.btn_veButton);
        progressBar = findViewById(R.id.progressBar);
        linearLayout = findViewById(R.id.Linearlayout);
    }
    class ButtonTask extends AsyncTask<Integer,Integer,Void>{
        @Override
        protected void onPreExecute() {
            linearLayout.removeAllViews();
            progressBar.setProgress(0);
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int n = integers[0];
            Random r = new Random();
            for (int i = 0 ;i<n;i++){
                int percent = i * 100/n;
                int value = r.nextInt(500);

                publishProgress(percent,value);
                SystemClock.sleep(100);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int value = values[1];
            int percent = values[0];
            txt_percent.setText(percent + "%");
            progressBar.setProgress(percent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT
            );
            Button button = new Button(MainActivity.this);
            button.setLayoutParams(layoutParams);
            button.setText(value+"");
            linearLayout.addView(button);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressBar.setProgress(100);
        }
    }
}