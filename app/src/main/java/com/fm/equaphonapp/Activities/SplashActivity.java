package com.fm.equaphonapp.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fm.equaphonapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity
{
    private static final long SPLASH_SCREEN_DELAY = 2500;
    private ProgressBar pbarProgreso;

    private MyAsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View v = getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        pbarProgreso = findViewById(R.id.progressBar);

        asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }

    private void tareaLarga()
    {
        try
        {
            Thread.sleep(300);
        } catch (InterruptedException e)
        {
        }
    }

    private class MyAsyncTask extends AsyncTask<Void, Integer, Boolean>
    {

        @Override
        protected Boolean doInBackground(Void... params)
        {

            for(int i=1; i<=10; i++)
            {
                tareaLarga();

                publishProgress(i*10);
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            int progreso = values[0].intValue();

            pbarProgreso.setProgress(progreso);
        }

        @Override
        protected void onPreExecute()
        {
            pbarProgreso.setMax(100);
            pbarProgreso.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            Intent intent = new Intent().setClass(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        protected void onCancelled()
        {
        }
    }
}
