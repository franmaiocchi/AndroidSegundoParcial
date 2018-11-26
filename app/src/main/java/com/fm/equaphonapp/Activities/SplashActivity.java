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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("brands");

        myRef.child("0").child("image").setValue(R.drawable.powersoft);
        myRef.child("1").child("image").setValue(R.drawable.touringseries);
        myRef.child("2").child("image").setValue(R.drawable.beyer);
        myRef.child("3").child("image").setValue(R.drawable.dpa);
        myRef.child("4").child("image").setValue(R.drawable.genelec);

        myRef = database.getReference("Powersoft");

        myRef.child("0").child("img").setValue(R.drawable.k2);
        myRef.child("1").child("img").setValue(R.drawable.k3);
        myRef.child("2").child("img").setValue(R.drawable.k6);
        myRef.child("3").child("img").setValue(R.drawable.k10);
        myRef.child("4").child("img").setValue(R.drawable.k20);
        myRef.child("5").child("img").setValue(R.drawable.m14d);
        myRef.child("6").child("img").setValue(R.drawable.m20d);
        myRef.child("7").child("img").setValue(R.drawable.m30d);
        myRef.child("8").child("img").setValue(R.drawable.m28q);
        myRef.child("9").child("img").setValue(R.drawable.m50q);
        myRef.child("10").child("img").setValue(R.drawable.x4);
        myRef.child("11").child("img").setValue(R.drawable.x8);

        myRef = database.getReference("STS");

        myRef.child("0").child("img").setValue(R.drawable.cantata);
        myRef.child("1").child("img").setValue(R.drawable.coax12);
        myRef.child("2").child("img").setValue(R.drawable.coax15);
        myRef.child("3").child("img").setValue(R.drawable.concerto);
        myRef.child("4").child("img").setValue(R.drawable.infra);
        myRef.child("5").child("img").setValue(R.drawable.mini);
        myRef.child("6").child("img").setValue(R.drawable.sonata);
        myRef.child("7").child("img").setValue(R.drawable.top);
        myRef.child("8").child("img").setValue(R.drawable.v10);
        myRef.child("9").child("img").setValue(R.drawable.v10i);
        myRef.child("10").child("img").setValue(R.drawable.v5);

        myRef = database.getReference("beyerdynamic");

        myRef.child("0").child("img").setValue(R.drawable.amironwireless);
        myRef.child("1").child("img").setValue(R.drawable.t1);
        myRef.child("2").child("img").setValue(R.drawable.t5);
        myRef.child("3").child("img").setValue(R.drawable.amironhome);
        myRef.child("4").child("img").setValue(R.drawable.t51i);
        myRef.child("5").child("img").setValue(R.drawable.dt880);
        myRef.child("6").child("img").setValue(R.drawable.dt990);
        myRef.child("7").child("img").setValue(R.drawable.cutomonepro);

        myRef = database.getReference("DPA");

        myRef.child("0").child("img").setValue(R.drawable.dpa4006);
        myRef.child("1").child("img").setValue(R.drawable.dpa2006);
        myRef.child("2").child("img").setValue(R.drawable.dpa4007);
        myRef.child("3").child("img").setValue(R.drawable.dpa409091);
        myRef.child("4").child("img").setValue(R.drawable.dpa4041);
        myRef.child("5").child("img").setValue(R.drawable.dpa2011);
        myRef.child("6").child("img").setValue(R.drawable.dpa4011);
        myRef.child("7").child("img").setValue(R.drawable.dpa4015);
        myRef.child("8").child("img").setValue(R.drawable.dpa4017);
        myRef.child("9").child("img").setValue(R.drawable.dpa4018);

        myRef = database.getReference("Genelec");

        myRef.child("0").child("img").setValue(R.drawable.genelec8010);
        myRef.child("1").child("img").setValue(R.drawable.genelec8020);
        myRef.child("2").child("img").setValue(R.drawable.genelec8030c);
        myRef.child("3").child("img").setValue(R.drawable.genelec8040b);
        myRef.child("4").child("img").setValue(R.drawable.genelec8050b);
        myRef.child("5").child("img").setValue(R.drawable.genelecm030);
        myRef.child("6").child("img").setValue(R.drawable.genelecm040);
        myRef.child("7").child("img").setValue(R.drawable.genelec7040a);
        myRef.child("8").child("img").setValue(R.drawable.genelec7050c);

        myRef = database.getReference("description-fragment");

        myRef.child("Powersoft").child("K10").child("imagen").setValue(R.drawable.k10);
        myRef.child("Powersoft").child("K2").child("imagen").setValue(R.drawable.k2);
        myRef.child("Powersoft").child("K20").child("imagen").setValue(R.drawable.k20);
        myRef.child("Powersoft").child("K3").child("imagen").setValue(R.drawable.k3);
        myRef.child("Powersoft").child("K6").child("imagen").setValue(R.drawable.k6);
        myRef.child("Powersoft").child("M14D").child("imagen").setValue(R.drawable.m14d);
        myRef.child("Powersoft").child("M20D").child("imagen").setValue(R.drawable.m20d);
        myRef.child("Powersoft").child("M28Q").child("imagen").setValue(R.drawable.m28q);
        myRef.child("Powersoft").child("M30D").child("imagen").setValue(R.drawable.m30d);
        myRef.child("Powersoft").child("M50Q").child("imagen").setValue(R.drawable.m50q);
        myRef.child("Powersoft").child("X4").child("imagen").setValue(R.drawable.x4);
        myRef.child("Powersoft").child("X8").child("imagen").setValue(R.drawable.x8);

        myRef.child("STS").child("Cantata").child("imagen").setValue(R.drawable.cantata);
        myRef.child("STS").child("Coax12").child("imagen").setValue(R.drawable.coax12);
        myRef.child("STS").child("Coax15").child("imagen").setValue(R.drawable.coax15);
        myRef.child("STS").child("Concerto INFRASUB").child("imagen").setValue(R.drawable.infra);
        myRef.child("STS").child("Concerto SUB").child("imagen").setValue(R.drawable.concerto);
        myRef.child("STS").child("Concerto TOP").child("imagen").setValue(R.drawable.top);
        myRef.child("STS").child("Concerto miniSUB").child("imagen").setValue(R.drawable.mini);
        myRef.child("STS").child("Linea V10").child("imagen").setValue(R.drawable.v10);
        myRef.child("STS").child("Linea V10i").child("imagen").setValue(R.drawable.v10i);
        myRef.child("STS").child("Linea V5").child("imagen").setValue(R.drawable.v5);
        myRef.child("STS").child("Sonata").child("imagen").setValue(R.drawable.sonata);

        myRef.child("beyerdynamic").child("Amiron wireless").child("imagen").setValue(R.drawable.amironwireless);
        myRef.child("beyerdynamic").child("T 1").child("imagen").setValue(R.drawable.t1);
        myRef.child("beyerdynamic").child("T 5 p").child("imagen").setValue(R.drawable.t5);
        myRef.child("beyerdynamic").child("Amiron home").child("imagen").setValue(R.drawable.amironhome);
        myRef.child("beyerdynamic").child("T 51 i").child("imagen").setValue(R.drawable.t51i);
        myRef.child("beyerdynamic").child("DT 880 Edition").child("imagen").setValue(R.drawable.dt880);
        myRef.child("beyerdynamic").child("DT 990 Edition").child("imagen").setValue(R.drawable.dt990);
        myRef.child("beyerdynamic").child("CUSTOM ONE PRO PLUS").child("imagen").setValue(R.drawable.cutomonepro);

        myRef.child("DPA").child("4006 Omnidirectional Microphone").child("imagen").setValue(R.drawable.dpa4006);
        myRef.child("DPA").child("2006 Twin Diaphragm Omnidirectional Microphone").child("imagen").setValue(R.drawable.dpa2006);
        myRef.child("DPA").child("4007 Omnidirectional Microphone").child("imagen").setValue(R.drawable.dpa4007);
        myRef.child("DPA").child("4090 Omnidirectional Microphone").child("imagen").setValue(R.drawable.dpa409091);
        myRef.child("DPA").child("4041-SP Omni Large Diaphragm Microphone").child("imagen").setValue(R.drawable.dpa4041);
        myRef.child("DPA").child("2011 Twin Diaphragm Cardioid Microphone").child("imagen").setValue(R.drawable.dpa2011);
        myRef.child("DPA").child("4011 Cardioid Microphone").child("imagen").setValue(R.drawable.dpa4011);
        myRef.child("DPA").child("4015 Wide Cardioid Microphone").child("imagen").setValue(R.drawable.dpa4015);
        myRef.child("DPA").child("4017 Shotgun Microphone").child("imagen").setValue(R.drawable.dpa4017);
        myRef.child("DPA").child("4018 Supercardioid Microphone").child("imagen").setValue(R.drawable.dpa4018);

        myRef.child("Genelec").child("8010A").child("imagen").setValue(R.drawable.genelec8010);
        myRef.child("Genelec").child("8020D").child("imagen").setValue(R.drawable.genelec8020);
        myRef.child("Genelec").child("8030C").child("imagen").setValue(R.drawable.genelec8030c);
        myRef.child("Genelec").child("8040B").child("imagen").setValue(R.drawable.genelec8040b);
        myRef.child("Genelec").child("8050B").child("imagen").setValue(R.drawable.genelec8050b);
        myRef.child("Genelec").child("M030").child("imagen").setValue(R.drawable.genelecm030);
        myRef.child("Genelec").child("M040").child("imagen").setValue(R.drawable.genelecm040);
        myRef.child("Genelec").child("7040A").child("imagen").setValue(R.drawable.genelec7040a);
        myRef.child("Genelec").child("7050C").child("imagen").setValue(R.drawable.genelec7050c);

        asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }

    private void tareaLarga()
    {
        try
        {
            Thread.sleep(200);
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
