package com.example.abdulali.careerkey;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.os.Handler;
import java.util.logging.LogRecord;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    Handler handler;

    private LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
handler = new Handler();

        progressBar = (ProgressBar) findViewById(R.id.Bar1);
        textView = (TextView) findViewById(R.id.textView1);


        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < progressBar.getMax()) {
                    progressStatus += 10;
                    //Update progress bar with completion of operation
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 300 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.post(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onBackPressed() {

        this.finish();
    }
}