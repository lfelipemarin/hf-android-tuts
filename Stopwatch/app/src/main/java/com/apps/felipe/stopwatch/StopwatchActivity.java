package com.apps.felipe.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    final static String LOG_STR = StopwatchActivity.class.getSimpleName();
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
            Log.d(LOG_STR, "Inside onCreate - savedInstance != null, seconds: " + seconds +
                    " running: " + running + " wasRunning: " + wasRunning);
        } else {
            Log.d(LOG_STR, "Inside onCreate, activity just created savedInstance = null," +
                    " seconds: " + seconds + " running: " + running + " wasRunning: " + wasRunning);
        }
        runTimer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
            Log.d(LOG_STR, "Inside onResume - if wasRunning = true, seconds: " + seconds +
                    " running: " + running + " wasRunning: " + wasRunning);
        } else {
            Log.d(LOG_STR, "Inside onResume - else wasRunning = false, seconds: " + seconds +
                    " running: " + running + " wasRunning: " + wasRunning);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
        Log.d(LOG_STR, "Inside onPausew, seconds: " + seconds + " running: " +
                running + " wasRunning: " + wasRunning);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
        Log.d(LOG_STR, "Inside onSaveInstance, seconds: " + seconds + " running: " +
                running + " wasRunning: " + wasRunning);
    }

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    //this method allows the timer to run as soon as posible using a Handler
    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        //post method runs code as soon as posible
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                //Log.d("Stopwatch", "This runs always " + time);
                //postDelayed method adds a delay to the post method
                handler.postDelayed(this, 1000);
            }
        });
    }
}
