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

/*        FirebaseDatabase database = FirebaseDatabase.getInstance();
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
        myRef.child("Genelec").child("7050C").child("imagen").setValue(R.drawable.genelec7050c);*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tech-specs-fragment");

        myRef.child("STS").child("Coax12").child("tipo").setValue("Dos vías pasivas, Full Range");
        myRef.child("STS").child("Coax12").child("respuesta en frecuencia").setValue("68 Hz – 18 kHz +/- 3dB");
        myRef.child("STS").child("Coax12").child("parlantes").setValue("1 x 1,4″ driver / 1 x 12″ woofer en configuración coaxial");
        myRef.child("STS").child("Coax12").child("sensibilidad").setValue("100 dB watt/metro");
        myRef.child("STS").child("Coax12").child("potencia").setValue("700 W programa continuo");
        myRef.child("STS").child("Coax12").child("impedancia").setValue("8 ohm nominal");
        myRef.child("STS").child("Coax12").child("gabinete").setValue("Reflector de bajos, multi ángulo monitor, 30°, 60° o 90°");
        myRef.child("STS").child("Coax12").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Coax12").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Coax12").child("anclajes").setValue("Vaso de 35 mm");
        myRef.child("STS").child("Coax12").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Coax12").child("dimensiones").setValue("(Al) 380mm x (An) 380mm x (P) 495mm");
        myRef.child("STS").child("Coax12").child("peso").setValue("15 kg");

        myRef.child("STS").child("Cantata").child("tipo").setValue("Dos vías pasivas, Full Range");
        myRef.child("STS").child("Cantata").child("respuesta en frecuencia").setValue("58 Hz – 20 kHz +/- 3dB");
        myRef.child("STS").child("Cantata").child("parlantes").setValue("1 x 1” driver / 1 x 12” woofer");
        myRef.child("STS").child("Cantata").child("sensibilidad").setValue("99 dB watt/metro");
        myRef.child("STS").child("Cantata").child("potencia").setValue("700 W programa continuo");
        myRef.child("STS").child("Cantata").child("impedancia").setValue("8 ohm nominal");
        myRef.child("STS").child("Cantata").child("gabinete").setValue("Reflector de bajos");
        myRef.child("STS").child("Cantata").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Cantata").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Cantata").child("anclajes").setValue("Sistema de puntos de rigging con 24 roscas de ¼, vaso de 35 mm");
        myRef.child("STS").child("Cantata").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Cantata").child("dimensiones").setValue("(Al) 650mm x (An) 383mm x (P) 350mm");
        myRef.child("STS").child("Cantata").child("peso").setValue("23 kg");

        myRef.child("STS").child("Coax15").child("tipo").setValue("Dos vías pasivas, Full Range");
        myRef.child("STS").child("Coax15").child("respuesta en frecuencia").setValue("55 Hz – 18 kHz +/- 3dB");
        myRef.child("STS").child("Coax15").child("parlantes").setValue("1 x 1,4″ driver / 1 x 15″ woofer en configuración coaxial");
        myRef.child("STS").child("Coax15").child("sensibilidad").setValue("100 dB watt/metro");
        myRef.child("STS").child("Coax15").child("potencia").setValue("700 W programa continuo");
        myRef.child("STS").child("Coax15").child("impedancia").setValue("8 ohm nominal");
        myRef.child("STS").child("Coax15").child("gabinete").setValue("Reflector de bajos, multi ángulo monitor, 30°, 60° o 90°");
        myRef.child("STS").child("Coax15").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Coax15").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Coax15").child("anclajes").setValue("Vaso de 35 mm");
        myRef.child("STS").child("Coax15").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Coax15").child("dimensiones").setValue("(Al) 380mm x (An) 380mm x (P) 495mm");
        myRef.child("STS").child("Coax15").child("peso").setValue("15 kg");

        myRef.child("STS").child("Concerto INFRASUB").child("tipo").setValue("Una vía, amplificación externa, configurable en arreglos cardioides");
        myRef.child("STS").child("Concerto INFRASUB").child("respuesta en frecuencia").setValue("28 Hz – 100 Hz –3dB/+0dB");
        myRef.child("STS").child("Concerto INFRASUB").child("parlantes").setValue("1 x 21 subwoofer Neodymium");
        myRef.child("STS").child("Concerto INFRASUB").child("sensibilidad").setValue("97 dB watt/metro");
        myRef.child("STS").child("Concerto INFRASUB").child("potencia").setValue("4000 W programa continuo");
        myRef.child("STS").child("Concerto INFRASUB").child("impedancia").setValue("4 ohm nominal");
        myRef.child("STS").child("Concerto INFRASUB").child("gabinete").setValue("Reflector de bajos, carga frontal");
        myRef.child("STS").child("Concerto INFRASUB").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Concerto INFRASUB").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Concerto INFRASUB").child("anclajes").setValue("48 puntos con roscas de ¼ para montaje de herrería exterior de colgado, o herraje opcional compatible con bumper y gabinetes Linea V5/V20, vaso de 35 mm");
        myRef.child("STS").child("Concerto INFRASUB").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Concerto INFRASUB").child("dimensiones").setValue("(Al) 610 mm, (An) 780 mm, (P) 780 mm");
        myRef.child("STS").child("Concerto INFRASUB").child("peso").setValue("65 kg");

        myRef.child("STS").child("Concerto SUB").child("tipo").setValue("Una vía, amplificación externa");
        myRef.child("STS").child("Concerto SUB").child("respuesta en frecuencia").setValue("36 Hz – 200 Hz +/- 3dB");
        myRef.child("STS").child("Concerto SUB").child("parlantes").setValue("2 x 18″ woofer");
        myRef.child("STS").child("Concerto SUB").child("sensibilidad").setValue("102 dB watt/metro");
        myRef.child("STS").child("Concerto SUB").child("potencia").setValue("4000 W programa continuo");
        myRef.child("STS").child("Concerto SUB").child("impedancia").setValue("4 ohm nominal");
        myRef.child("STS").child("Concerto SUB").child("gabinete").setValue("Dos cámaras, reflector de bajos, carga frontal");
        myRef.child("STS").child("Concerto SUB").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Concerto SUB").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Concerto SUB").child("anclajes").setValue("24 puntos con roscas de ¼ para montaje de herrería exterior de colgado, vaso de 35 mm");
        myRef.child("STS").child("Concerto SUB").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Concerto SUB").child("dimensiones").setValue("(Al) 1100 mm, (An) 610 mm, (P) 650 mm");
        myRef.child("STS").child("Concerto SUB").child("peso").setValue("78 kg");

        myRef.child("STS").child("Concerto TOP").child("tipo").setValue("Tres vías, bi-amplificable, mid/high pasiva");
        myRef.child("STS").child("Concerto TOP").child("respuesta en frecuencia").setValue("44 Hz – 18 kHz +/- 3dB");
        myRef.child("STS").child("Concerto TOP").child("parlantes").setValue("1 x 1,4″ driver / 1 x 10″ Mid Range / 2 x 15″ Woofer");
        myRef.child("STS").child("Concerto TOP").child("sensibilidad").setValue("108 dB watt/metro Mid-High, 104 dB watt/metro Low");
        myRef.child("STS").child("Concerto TOP").child("potencia").setValue("900 W programa continuo Mid-High, 1600 W programa continuo Low");
        myRef.child("STS").child("Concerto TOP").child("impedancia").setValue("8 ohm nominal Mid-High, 4 ohm nominal Low");
        myRef.child("STS").child("Concerto TOP").child("gabinete").setValue("Carga bocina radiador de bajos low, guía de onda octogonal Mid, directividad constante High");
        myRef.child("STS").child("Concerto TOP").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Concerto TOP").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Concerto TOP").child("anclajes").setValue("30 puntos con roscas de ¼ para montaje de herrería exterior de colgado");
        myRef.child("STS").child("Concerto TOP").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Concerto TOP").child("dimensiones").setValue("(Al) 1100 mm, (An) 610 mm, (P) 650 mm");
        myRef.child("STS").child("Concerto TOP").child("peso").setValue("79 kg");

        myRef.child("STS").child("Concerto miniSUB").child("tipo").setValue("Una vía, amplificación externa, configurable en arreglos cardioides");
        myRef.child("STS").child("Concerto miniSUB").child("respuesta en frecuencia").setValue("40 Hz – 200 Hz +/- 3dB");
        myRef.child("STS").child("Concerto miniSUB").child("parlantes").setValue("1 x 18″");
        myRef.child("STS").child("Concerto miniSUB").child("sensibilidad").setValue("99 dB watt/metro");
        myRef.child("STS").child("Concerto miniSUB").child("potencia").setValue("1200 W programa continuo");
        myRef.child("STS").child("Concerto miniSUB").child("impedancia").setValue("4 u 8 ohm nominal");
        myRef.child("STS").child("Concerto miniSUB").child("gabinete").setValue("Reflector de bajos, carga frontal");
        myRef.child("STS").child("Concerto miniSUB").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Concerto miniSUB").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Concerto miniSUB").child("anclajes").setValue("24 puntos con roscas de ¼ para montaje de herrería exterior de colgado, vaso de 35 mm");
        myRef.child("STS").child("Concerto miniSUB").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Concerto miniSUB").child("dimensiones").setValue("(Al) 550 mm, (An) 610 mm, (P) 610 mm");
        myRef.child("STS").child("Concerto miniSUB").child("peso").setValue("37 kg");

        myRef.child("STS").child("Linea V10").child("tipo").setValue("Dos vías, Full Range");
        myRef.child("STS").child("Linea V10").child("respuesta en frecuencia").setValue("80 Hz – 18 kHz +/- 3dB");
        myRef.child("STS").child("Linea V10").child("parlantes").setValue("1 x 1″ driver Neodymium / 1 x 8″ woofer Neodymium");
        myRef.child("STS").child("Linea V10").child("sensibilidad").setValue("97 dB watt/metro");
        myRef.child("STS").child("Linea V10").child("potencia").setValue("500 W programa continuo, 1000 W pico");
        myRef.child("STS").child("Linea V10").child("impedancia").setValue("8 ohm nominal");
        myRef.child("STS").child("Linea V10").child("gabinete").setValue("Horizontal con rigging de colgado para line array");
        myRef.child("STS").child("Linea V10").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Linea V10").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Linea V10").child("anclajes").setValue("Sistema de rigging con 5 posiciones (0°, 2,5°, 5°, 7,5°, 10°)");
        myRef.child("STS").child("Linea V10").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Linea V10").child("dimensiones").setValue("(Al) 245mm x (An) 490mm x (P) 320mm con rigging");
        myRef.child("STS").child("Linea V10").child("peso").setValue("15 Kg");

        myRef.child("STS").child("Linea V10i").child("tipo").setValue("Dos vías, Full Range");
        myRef.child("STS").child("Linea V10i").child("respuesta en frecuencia").setValue("80 Hz – 18 kHz +/- 3dB");
        myRef.child("STS").child("Linea V10i").child("parlantes").setValue("1 x 1″ driver Neodymium / 1 x 8″ woofer Neodymium");
        myRef.child("STS").child("Linea V10i").child("sensibilidad").setValue("97 dB watt/metro");
        myRef.child("STS").child("Linea V10i").child("potencia").setValue("500 W programa continuo, 1000 W pico");
        myRef.child("STS").child("Linea V10i").child("impedancia").setValue("8 ohm nominal");
        myRef.child("STS").child("Linea V10i").child("gabinete").setValue("Horizontal con rigging fijo entre cajas");
        myRef.child("STS").child("Linea V10i").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Linea V10i").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Linea V10i").child("anclajes").setValue("-");
        myRef.child("STS").child("Linea V10i").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Linea V10i").child("dimensiones").setValue("(Al) 245mm x (An) 425mm x (P) 320mm");
        myRef.child("STS").child("Linea V10i").child("peso").setValue("11 Kg");

        myRef.child("STS").child("Linea V5").child("tipo").setValue("Tres vías, bi-amplificable, mid/high pasiva");
        myRef.child("STS").child("Linea V5").child("respuesta en frecuencia").setValue("55 Hz – 18 kHz +/- 3dB");
        myRef.child("STS").child("Linea V5").child("parlantes").setValue("2 x 1″ driver Neodymium / 2 x 8″ Mid Range/ 1 x 15″ Woofer");
        myRef.child("STS").child("Linea V5").child("sensibilidad").setValue("102 dB watt/metro Mid-High, 99 dB watt/metro Low");
        myRef.child("STS").child("Linea V5").child("potencia").setValue("1000 W programa continuo Mid-High, 1100 W programa continuo Low");
        myRef.child("STS").child("Linea V5").child("impedancia").setValue("16 ohm nominal Mid-High, 8 ohm nominal Low");
        myRef.child("STS").child("Linea V5").child("gabinete").setValue("Horizontal con rigging de colgado para line array");
        myRef.child("STS").child("Linea V5").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Linea V5").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Linea V5").child("anclajes").setValue("Sistema de rigging con 6 posiciones\\n\" +\n" +
                "                \"V5 – (0°, 1°, 2°, 3°, 4°, 5°)\\n\" +\n" +
                "                \"V20 – (0°, 2,5°, 5°, 7,5°, 10°, 12,5°)");
        myRef.child("STS").child("Linea V5").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Linea V5").child("dimensiones").setValue("V5 – (Al) 460 mm x (An) 830 mm x (P) 310 mm\\n\" +\n" +
                "                \"V20 – (Al) 460 mm x (An) 830 mm x (P) 305 mm");
        myRef.child("STS").child("Linea V5").child("peso").setValue("V5 47 Kg\\n\" +\n" +
                "                \"V20 46 Kg");


        myRef.child("STS").child("Sonata").child("tipo").setValue("Dos vías pasivas, Full Range");
        myRef.child("STS").child("Sonata").child("respuesta en frecuencia").setValue("48 Hz – 18 kHz +/- 3dB");
        myRef.child("STS").child("Sonata").child("parlantes").setValue("1 x 1,4″ driver / 1 x 15″ woofer");
        myRef.child("STS").child("Sonata").child("sensibilidad").setValue("100 dB watt/metro");
        myRef.child("STS").child("Sonata").child("potencia").setValue("960 W programa continuo");
        myRef.child("STS").child("Sonata").child("impedancia").setValue("8 ohm nominal");
        myRef.child("STS").child("Sonata").child("gabinete").setValue("Reflector de bajos, trapezoidal multiángulo");
        myRef.child("STS").child("Sonata").child("terminacion").setValue("Cubierta c/poliurea, texturada, azul-gris oscuro");
        myRef.child("STS").child("Sonata").child("reja").setValue("Negra, chapa hierro perforado");
        myRef.child("STS").child("Sonata").child("anclajes").setValue("24 puntos con roscas de ¼ para montaje de herrería exterior de colgado, vaso de 35 mm");
        myRef.child("STS").child("Sonata").child("conectores").setValue("2 x Neutrik Speakon");
        myRef.child("STS").child("Sonata").child("dimensiones").setValue("(Al) 760mm x (An) 500mm x (P) 400mm");
        myRef.child("STS").child("Sonata").child("peso").setValue("37 kg");

        myRef.child("Powersoft").child("K20").child("potencia 2").setValue("9000W");
        myRef.child("Powersoft").child("K20").child("potencia 4").setValue("5200W");
        myRef.child("Powersoft").child("K20").child("potencia 8").setValue("2700W");

        myRef.child("Powersoft").child("K10").child("potencia 2").setValue("6000W");
        myRef.child("Powersoft").child("K10").child("potencia 4").setValue("4000W");
        myRef.child("Powersoft").child("K10").child("potencia 8").setValue("2000W");

        myRef.child("Powersoft").child("K6").child("potencia 2").setValue("3600W");
        myRef.child("Powersoft").child("K6").child("potencia 4").setValue("2500W");
        myRef.child("Powersoft").child("K6").child("potencia 8").setValue("1300W");

        myRef.child("Powersoft").child("K3").child("potencia 2").setValue("2800W");
        myRef.child("Powersoft").child("K3").child("potencia 4").setValue("2600W");
        myRef.child("Powersoft").child("K3").child("potencia 8").setValue("1400W");

        myRef.child("Powersoft").child("K2").child("potencia 2").setValue("2400W");
        myRef.child("Powersoft").child("K2").child("potencia 4").setValue("1950W");
        myRef.child("Powersoft").child("K2").child("potencia 8").setValue("1000W");

        myRef.child("Powersoft").child("M50Q").child("potencia 2").setValue("-");
        myRef.child("Powersoft").child("M50Q").child("potencia 4").setValue("1250W");
        myRef.child("Powersoft").child("M50Q").child("potencia 8").setValue("750W");

        myRef.child("Powersoft").child("M28Q").child("potencia 2").setValue("-");
        myRef.child("Powersoft").child("M28Q").child("potencia 4").setValue("700W");
        myRef.child("Powersoft").child("M28Q").child("potencia 8").setValue("360W");

        myRef.child("Powersoft").child("M30D").child("potencia 2").setValue("-");
        myRef.child("Powersoft").child("M30D").child("potencia 4").setValue("1500W");
        myRef.child("Powersoft").child("M30D").child("potencia 8").setValue("900W");

        myRef.child("Powersoft").child("M20D").child("potencia 2").setValue("-");
        myRef.child("Powersoft").child("M20D").child("potencia 4").setValue("1200W");
        myRef.child("Powersoft").child("M20D").child("potencia 8").setValue("600W");

        myRef.child("Powersoft").child("M14D").child("potencia 2").setValue("-");
        myRef.child("Powersoft").child("M14D").child("potencia 4").setValue("700W");
        myRef.child("Powersoft").child("M14D").child("potencia 8").setValue("360W");

        myRef.child("Powersoft").child("X4").child("potencia 2").setValue("5200W");
        myRef.child("Powersoft").child("X4").child("potencia 4").setValue("3000W");
        myRef.child("Powersoft").child("X4").child("potencia 8").setValue("1600W");

        myRef.child("Powersoft").child("X8").child("potencia 2").setValue("5200W");
        myRef.child("Powersoft").child("X8").child("potencia 4").setValue("3000W");
        myRef.child("Powersoft").child("X8").child("potencia 8").setValue("1600W");

        myRef.child("beyerdynamic").child("Amiron wireless").child("OPERATING PRINCIPLE").setValue("Closed");
        myRef.child("beyerdynamic").child("Amiron wireless").child("IMPEDANCE").setValue("32 ohms");
        myRef.child("beyerdynamic").child("Amiron wireless").child("FREQUENCY RESPONSE").setValue("5-40,000 Hz");
        myRef.child("beyerdynamic").child("Amiron wireless").child("SOUND PRESSURE LEVEL").setValue("100 dB");

        myRef.child("beyerdynamic").child("T 1").child("OPERATING PRINCIPLE").setValue("Semi-Open");
        myRef.child("beyerdynamic").child("T 1").child("IMPEDANCE").setValue("600 ohms");
        myRef.child("beyerdynamic").child("T 1").child("FREQUENCY RESPONSE").setValue("5 - 50,000 Hz");
        myRef.child("beyerdynamic").child("T 1").child("SOUND PRESSURE LEVEL").setValue("102 dB (1mW / 500 Hz)");

        myRef.child("beyerdynamic").child("T 5 p").child("OPERATING PRINCIPLE").setValue("Closed");
        myRef.child("beyerdynamic").child("T 5 p").child("IMPEDANCE").setValue("32 ohms");
        myRef.child("beyerdynamic").child("T 5 p").child("FREQUENCY RESPONSE").setValue("5 - 50,000 Hz");
        myRef.child("beyerdynamic").child("T 5 p").child("SOUND PRESSURE LEVEL").setValue("102 dB (1mW / 500 Hz)");

        myRef.child("beyerdynamic").child("Amiron home").child("OPERATING PRINCIPLE").setValue("Open");
        myRef.child("beyerdynamic").child("Amiron home").child("IMPEDANCE").setValue("250 ohms");
        myRef.child("beyerdynamic").child("Amiron home").child("FREQUENCY RESPONSE").setValue("5-40,000 Hz");
        myRef.child("beyerdynamic").child("Amiron home").child("SOUND PRESSURE LEVEL").setValue("102 dB (1 mW / 500 Hz)");

        myRef.child("beyerdynamic").child("T 51 i").child("OPERATING PRINCIPLE").setValue("Closed");
        myRef.child("beyerdynamic").child("T 51 i").child("IMPEDANCE").setValue("32 ohms");
        myRef.child("beyerdynamic").child("T 51 i").child("FREQUENCY RESPONSE").setValue("10 Hz - 23,000 Hz");
        myRef.child("beyerdynamic").child("T 51 i").child("SOUND PRESSURE LEVEL").setValue("111 dB");

        myRef.child("beyerdynamic").child("DT 880 Edition").child("OPERATING PRINCIPLE").setValue("Semi-Open");
        myRef.child("beyerdynamic").child("DT 880 Edition").child("IMPEDANCE").setValue("32/250/600 ohms");
        myRef.child("beyerdynamic").child("DT 880 Edition").child("FREQUENCY RESPONSE").setValue("5 Hz - 35,000 Hz");
        myRef.child("beyerdynamic").child("DT 880 Edition").child("SOUND PRESSURE LEVEL").setValue("96 dB");

        myRef.child("beyerdynamic").child("DT 990 Edition").child("OPERATING PRINCIPLE").setValue("Open");
        myRef.child("beyerdynamic").child("DT 990 Edition").child("IMPEDANCE").setValue("32/250/600 ohms");
        myRef.child("beyerdynamic").child("DT 990 Edition").child("FREQUENCY RESPONSE").setValue("5 - 35.000 Hz");
        myRef.child("beyerdynamic").child("DT 990 Edition").child("SOUND PRESSURE LEVEL").setValue("96 dB");

        myRef.child("beyerdynamic").child("CUSTOM ONE PRO PLUS").child("OPERATING PRINCIPLE").setValue("Closed");
        myRef.child("beyerdynamic").child("CUSTOM ONE PRO PLUS").child("IMPEDANCE").setValue("16 ohms");
        myRef.child("beyerdynamic").child("CUSTOM ONE PRO PLUS").child("FREQUENCY RESPONSE").setValue("5 Hz - 35,000 Hz");
        myRef.child("beyerdynamic").child("CUSTOM ONE PRO PLUS").child("SOUND PRESSURE LEVEL").setValue("96 dB");

        myRef.child("DPA").child("4006 Omnidirectional Microphone").child("Directional pattern").setValue("Omnidirectional");
        myRef.child("DPA").child("4006 Omnidirectional Microphone").child("Principle of operation").setValue("Pressure");
        myRef.child("DPA").child("4006 Omnidirectional Microphone").child("Frequency range").setValue("10 Hz - 20 kHz");
        myRef.child("DPA").child("4006 Omnidirectional Microphone").child("Frequency range, ±2 dB").setValue("10 Hz - 20 kHz");

        myRef.child("DPA").child("2006 Twin Diaphragm Omnidirectional Microphone").child("Directional pattern").setValue("Omnidirectional");
        myRef.child("DPA").child("2006 Twin Diaphragm Omnidirectional Microphone").child("Principle of operation").setValue("Pressure");
        myRef.child("DPA").child("2006 Twin Diaphragm Omnidirectional Microphone").child("Frequency range").setValue("20 Hz - 20 kHz");
        myRef.child("DPA").child("2006 Twin Diaphragm Omnidirectional Microphone").child("Frequency range, ±2 dB").setValue("50 Hz - 20 kHz with typ. 3 dB soft boost at 14 kHz");

        myRef.child("DPA").child("4007 Omnidirectional Microphone").child("Directional pattern").setValue("Omnidirectional");
        myRef.child("DPA").child("4007 Omnidirectional Microphone").child("Principle of operation").setValue("Pressure");
        myRef.child("DPA").child("4007 Omnidirectional Microphone").child("Frequency range").setValue("10 Hz - 40 kHz");
        myRef.child("DPA").child("4007 Omnidirectional Microphone").child("Frequency range, ±2 dB").setValue("10 Hz - 40 kHz");

        myRef.child("DPA").child("4090 Omnidirectional Microphone").child("Directional pattern").setValue("Omnidirectional");
        myRef.child("DPA").child("4090 Omnidirectional Microphone").child("Principle of operation").setValue("Pressure");
        myRef.child("DPA").child("4090 Omnidirectional Microphone").child("Frequency range").setValue("20 Hz - 20 kHz");
        myRef.child("DPA").child("4090 Omnidirectional Microphone").child("Frequency range, ±2 dB").setValue("20 Hz - 20 kHz");

        myRef.child("DPA").child("4041-SP Omni Large Diaphragm Microphone").child("Directional pattern").setValue("Omnidirectional");
        myRef.child("DPA").child("4041-SP Omni Large Diaphragm Microphone").child("Principle of operation").setValue("Pressure");
        myRef.child("DPA").child("4041-SP Omni Large Diaphragm Microphone").child("Frequency range").setValue("20 Hz - 20 kHz");
        myRef.child("DPA").child("4041-SP Omni Large Diaphragm Microphone").child("Frequency range, ±2 dB").setValue("20 Hz - 20 kHz with 4 - 6 dB soft boost at 8 kHz");

        myRef.child("DPA").child("2011 Twin Diaphragm Cardioid Microphone").child("Directional pattern").setValue("Cardioid");
        myRef.child("DPA").child("2011 Twin Diaphragm Cardioid Microphone").child("Principle of operation").setValue("Pressure gradient, with interference tube");
        myRef.child("DPA").child("2011 Twin Diaphragm Cardioid Microphone").child("Frequency range").setValue("20 Hz - 20 kHz");
        myRef.child("DPA").child("2011 Twin Diaphragm Cardioid Microphone").child("Frequency range, ±2 dB").setValue("50 Hz - 17 kHz with 3 dB soft boost at 12 kHz");

        myRef.child("DPA").child("4011 Cardioid Microphone").child("Directional pattern").setValue("Cardioid");
        myRef.child("DPA").child("4011 Cardioid Microphone").child("Principle of operation").setValue("Pressure gradient");
        myRef.child("DPA").child("4011 Cardioid Microphone").child("Frequency range").setValue("20 Hz - 20 kHz");
        myRef.child("DPA").child("4011 Cardioid Microphone").child("Frequency range, ±2 dB").setValue("40 Hz - 20 kHz");

        myRef.child("DPA").child("4015 Wide Cardioid Microphone").child("Directional pattern").setValue("Wide cardioid");
        myRef.child("DPA").child("4015 Wide Cardioid Microphone").child("Principle of operation").setValue("Pressure gradient");
        myRef.child("DPA").child("4015 Wide Cardioid Microphone").child("Frequency range").setValue("20 Hz - 20 kHz");
        myRef.child("DPA").child("4015 Wide Cardioid Microphone").child("Frequency range, ±2 dB").setValue("40 Hz - 20 kHz");

        myRef.child("DPA").child("4017 Shotgun Microphone").child("Directional pattern").setValue("Supercardioid, lobe-shaped");
        myRef.child("DPA").child("4017 Shotgun Microphone").child("Principle of operation").setValue("Pressure gradient, with interference tube");
        myRef.child("DPA").child("4017 Shotgun Microphone").child("Frequency range").setValue("20 Hz - 20 kHz, permanent third order high pass filter at 50 Hz");
        myRef.child("DPA").child("4017 Shotgun Microphone").child("Frequency range, ±2 dB").setValue("70 Hz - 18 kHz with typ. 3 dB soft boost at 15 kHz");

        myRef.child("DPA").child("4018 Supercardioid Microphone").child("Directional pattern").setValue("Supercardioid");
        myRef.child("DPA").child("4018 Supercardioid Microphone").child("Principle of operation").setValue("Pressure gradient");
        myRef.child("DPA").child("4018 Supercardioid Microphone").child("Frequency range").setValue("20 Hz - 20 kHz");
        myRef.child("DPA").child("4018 Supercardioid Microphone").child("Frequency range, ±2 dB").setValue("40 Hz - 18 kHz");

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
