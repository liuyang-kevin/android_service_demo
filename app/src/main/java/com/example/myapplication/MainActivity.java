package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playBtn;
    private Button stopBtn;
    private Button pauseBtn;
    private Button exitBtn;
    private Button closeBtn;

    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (Button) findViewById(R.id.button5);
        stopBtn = (Button) findViewById(R.id.button3);
        pauseBtn = (Button) findViewById(R.id.button2);
        exitBtn = (Button) findViewById(R.id.button);
        closeBtn = (Button) findViewById(R.id.button4);

        playBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
        closeBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int op = -1;
        intent = new Intent("com.msicService");
//        intent = new Intent(this, MusicService.class);

        switch (v.getId()) {
            case R.id.button5:								// play music
                op = 1;
                break;
            case R.id.button3:								// stop music
                op = 2;
                break;
            case R.id.button2:							// pause music
                op = 3;
                break;
            case R.id.button4:							// close activity
                this.finish();
                break;
            case R.id.button:								// stopService
                op = 4;
                stopService(intent);
                this.finish();
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("op", op);
        intent.putExtras(bundle);

        startService(intent);							// startService
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        if(intent != null){
            stopService(intent);
        }
    }
}
