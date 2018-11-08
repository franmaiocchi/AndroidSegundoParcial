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
public class DescriptionFragment extends android.support.v4.app.Fragment
{
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

}
