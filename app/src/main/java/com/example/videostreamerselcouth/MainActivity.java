package com.example.videostreamerselcouth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import np.com.sudishrestha.selcouthstreamer.interfaces.streamInterface;

public class MainActivity extends AppCompatActivity implements  streamInterface {
    np.com.sudishrestha.selcouthstreamer.streamer streamer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        streamer = findViewById(R.id.mystream);
        streamer.setMstreamInterface(this);


    }

    @Override
    public void onClick(String username, String type, String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }
}