package com.jdy.weijie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.jdy.weijie.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by JinDouYun on 13-11-22.
 */
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        init();
    }

    private void init() {
        final Intent intent = new Intent(this, MainActivity.class);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        };
        timer.schedule(timerTask,1000*2);
    }

}
