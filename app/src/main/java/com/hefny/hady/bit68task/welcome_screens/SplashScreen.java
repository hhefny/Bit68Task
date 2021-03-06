package com.hefny.hady.bit68task.welcome_screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.hefny.hady.bit68task.R;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SplashScreen extends AppCompatActivity {

    // variables
    private static final String TAG = "SplashScreen";
    private Handler handler;
    private Runnable runnable;
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        runnable = this::launchMainActivity;
        handler = new Handler();
        handler.postDelayed(runnable, SPLASH_DISPLAY_LENGTH);
    }

    private void launchMainActivity() {
        Intent i = new Intent(SplashScreen.this, WelcomeScreen.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}