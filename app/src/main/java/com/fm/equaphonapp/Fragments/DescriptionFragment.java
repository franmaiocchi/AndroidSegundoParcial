package com.fm.equaphonapp.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class DescriptionFragment extends android.support.v4.app.Fragment
{
    private TextView lblDescripcion;
    private ImageView imgDescripcion;

    public static DescriptionFragment newInstance()
    {
        DescriptionFragment newFragment = new DescriptionFragment();
        return newFragment;
    }

    public DescriptionFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        String modelo = getArguments().getString("MODELO");
        String brand = getArguments().getString("BRAND");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_description, container, false);

        lblDescripcion = v.findViewById(R.id.lblDescripcion);
        imgDescripcion = v.findViewById(R.id.imgDescripcion);

        DatabaseReference dbDescription = FirebaseDatabase.getInstance().getReference()
                .child("description-fragment")
                .child(brand)
                .child(modelo);

        ValueEventListener eventListener = new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                lblDescripcion.setText(dataSnapshot.child("descripcion").getValue(String.class));
                imgDescripcion.setImageResource(dataSnapshot.child("imagen").getValue(int.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        };
        dbDescription.addListenerForSingleValueEvent(eventListener);

        return v;
    }

}
