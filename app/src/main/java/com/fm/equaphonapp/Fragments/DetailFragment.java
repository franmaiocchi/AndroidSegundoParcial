package com.fm.equaphonapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fm.equaphonapp.Adapters.ViewPagerAdapter;
import com.fm.equaphonapp.Messages.MessageEvent;
import com.fm.equaphonapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment
{
    private String model;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    public DetailFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    // UI updates must run on MainThread
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event)
    {
        this.model = event.message;
        EventBus.getDefault().removeStickyEvent(event);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Antes que nada veo que marca se clickeo!
        MessageEvent stickyEvent = EventBus.getDefault().getStickyEvent(MessageEvent.class);

        if(stickyEvent != null) {
            // "Consume" the sticky event
            EventBus.getDefault().removeStickyEvent(stickyEvent);
            this.model = stickyEvent.message;
        }

        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.appbartabs);

        // Set up the toolbar
        setUpToolbar(view);

        // Set up the viewpager
        setUpViewPager(viewPager, this.model);

        // Set up the tabs
        tabLayout = view.findViewById(R.id.appbartabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null)
        {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setTitle(this.model);
        }
    }

    private void setUpViewPager(ViewPager viewPager, String modelo)
    {
        Bundle bundle = new Bundle();
        bundle.putString("MODELO", modelo);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        LayoutInflater inflator = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        DescriptionFragment fragment1 = new DescriptionFragment();
        fragment1.setArguments(bundle);
        adapter.addFrag(fragment1, "Descripción");

        TechSpecsFragment fragment2 = new TechSpecsFragment();
        fragment2.setArguments(bundle);
        adapter.addFrag(fragment2, "Especificaciones técnicas");

        viewPager.setAdapter(adapter);
    }
}
