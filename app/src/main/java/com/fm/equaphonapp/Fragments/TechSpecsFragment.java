package com.fm.equaphonapp.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fm.equaphonapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechSpecsFragment extends android.support.v4.app.Fragment
{
    private View v;

    public static TechSpecsFragment newInstance()
    {
        TechSpecsFragment newFragment = new TechSpecsFragment();
        return newFragment;
    }

    public TechSpecsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        String modelo = getArguments().getString("MODELO");
        String brand = getArguments().getString("BRAND");

        switch (brand)
        {
            case "Powersoft":
                // Inflate the layout for this fragment
                v = inflater.inflate(R.layout.fragment_tech_specs_powersoft, container, false);

                final TextView lblPot2 = v.findViewById(R.id.lblPot2);
                final TextView lblPot4 = v.findViewById(R.id.lblPot4);
                final TextView lblPot8 = v.findViewById(R.id.lblPot8);

                final DatabaseReference dbRef_pow = FirebaseDatabase.getInstance().getReference()
                        .child("tech-specs-fragment")
                        .child(brand)
                        .child(modelo);

                ValueEventListener eventListener_pow = new ValueEventListener()
                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        lblPot2.setText(dataSnapshot.child("potencia 2").getValue(String.class));
                        lblPot4.setText(dataSnapshot.child("potencia 4").getValue(String.class));
                        lblPot8.setText(dataSnapshot.child("potencia 8").getValue(String.class));
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {

                    }
                };
                dbRef_pow.addListenerForSingleValueEvent(eventListener_pow);
                break;

            case "STS":
                // Inflate the layout for this fragment
                v = inflater.inflate(R.layout.fragment_tech_specs_sts, container, false);

                // Obtengo las referencias
                final TextView lblTipo = v.findViewById(R.id.lblTipo);
                final TextView lblRespuestaEnFrecuencia = v.findViewById(R.id.lblRespuestaEnFrecuencia);
                final TextView lblParlantes = v.findViewById(R.id.lblParlantes);
                final TextView lblSensibilidad = v.findViewById(R.id.lblSensibilidad);
                final TextView lblCapacidadDePotencia = v.findViewById(R.id.lblCapacidadDePotencia);
                final TextView lblImpedancia = v.findViewById(R.id.lblImpedancia);
                final TextView lblGabinete = v.findViewById(R.id.lblGabinete);
                final TextView lblTerminacion = v.findViewById(R.id.lblTerminacion);
                final TextView lblRejaDeProteccion = v.findViewById(R.id.lblRejaDeProteccion);
                final TextView lblAnclajes = v.findViewById(R.id.lblAnclajes);
                final TextView lblConectores = v.findViewById(R.id.lblConectores);
                final TextView lblDimensiones = v.findViewById(R.id.lblDimensiones);
                final TextView lblPeso = v.findViewById(R.id.lblPeso);

                final DatabaseReference dbRef_sts = FirebaseDatabase.getInstance().getReference()
                        .child("tech-specs-fragment")
                        .child(brand)
                        .child(modelo);

                ValueEventListener eventListener_sts = new ValueEventListener()
                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        lblTipo.setText(dataSnapshot.child("tipo").getValue(String.class));
                        lblRespuestaEnFrecuencia.setText(dataSnapshot.child("respuesta en frecuencia").getValue(String.class));
                        lblParlantes.setText(dataSnapshot.child("parlantes").getValue(String.class));
                        lblSensibilidad.setText(dataSnapshot.child("sensibilidad").getValue(String.class));
                        lblCapacidadDePotencia.setText(dataSnapshot.child("potencia").getValue(String.class));
                        lblImpedancia.setText(dataSnapshot.child("impedancia").getValue(String.class));
                        lblGabinete.setText(dataSnapshot.child("gabinete").getValue(String.class));
                        lblTerminacion.setText(dataSnapshot.child("terminacion").getValue(String.class));
                        lblRejaDeProteccion.setText(dataSnapshot.child("reja").getValue(String.class));
                        lblAnclajes.setText(dataSnapshot.child("anclajes").getValue(String.class));
                        lblConectores.setText(dataSnapshot.child("conectores").getValue(String.class));
                        lblDimensiones.setText(dataSnapshot.child("dimensiones").getValue(String.class));
                        lblPeso.setText(dataSnapshot.child("peso").getValue(String.class));
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {

                    }
                };
                dbRef_sts.addListenerForSingleValueEvent(eventListener_sts);

                break;

            case "beyerdynamic":
                // Inflate the layout for this fragment
                v = inflater.inflate(R.layout.fragment_tech_specs, container, false);
                break;

            case "DPA":
                // Inflate the layout for this fragment
                v = inflater.inflate(R.layout.fragment_tech_specs, container, false);
                break;

            case "Genelec":
                // Inflate the layout for this fragment
                v = inflater.inflate(R.layout.fragment_tech_specs, container, false);
                break;
        }

        // Inflate the layout for this fragment
        return v;
    }

}
