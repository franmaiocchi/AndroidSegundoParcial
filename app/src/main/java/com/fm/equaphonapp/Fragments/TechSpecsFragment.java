package com.fm.equaphonapp.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fm.equaphonapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechSpecsFragment extends android.support.v4.app.Fragment
{
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tech_specs, container, false);
    }

}
