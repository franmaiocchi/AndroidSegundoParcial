package com.fm.equaphonapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.fm.equaphonapp.Adapters.BrandAdapter;
import com.fm.equaphonapp.Adapters.STSAdapter;
import com.fm.equaphonapp.Clases.Brand;
import com.fm.equaphonapp.Clases.STS;
import com.fm.equaphonapp.Decoration.BrandItemDecoration;
import com.fm.equaphonapp.Messages.MessageEvent;
import com.fm.equaphonapp.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment
{
    private String brand;
    private ArrayList<STS> data;
    private RecyclerView recView;
    private STSAdapter adapter;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    // UI updates must run on MainThread
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event)
    {
        this.brand = event.message;
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
        // Antes que nada veo que marca se clickeo!
        MessageEvent stickyEvent = EventBus.getDefault().getStickyEvent(MessageEvent.class);

        if(stickyEvent != null) {
            // "Consume" the sticky event
            EventBus.getDefault().removeStickyEvent(stickyEvent);
            this.brand = stickyEvent.message;
        }

/*        // create ContextThemeWrapper from the original Activity Context with the custom theme
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_STS);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

        // inflate the layout using the cloned inflater, not default inflater
        View view = localInflater.inflate(R.layout.fragment_second, container, false);*/

        getActivity().setTheme(R.style.Theme_STS);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        if (this.brand.equals("Powersoft"))
        {
            data = new ArrayList<STS>();
            data.add(new STS("K2", R.drawable.k2));
            data.add(new STS("K3", R.drawable.k3));
            data.add(new STS("K6", R.drawable.k6));
            data.add(new STS("K10", R.drawable.k10));
            data.add(new STS("K20", R.drawable.k20));
            data.add(new STS("M14D", R.drawable.m14d));
            data.add(new STS("M20D", R.drawable.m20d));
            data.add(new STS("M30D", R.drawable.m30d));
            data.add(new STS("M28Q", R.drawable.m28q));
            data.add(new STS("M50Q", R.drawable.m50q));
            data.add(new STS("X4", R.drawable.x4));
            data.add(new STS("X8", R.drawable.x8));
        }
        else
        {
            data = new ArrayList<STS>();
            data.add(new STS("Cantata", R.drawable.cantata));
            data.add(new STS("Coax12", R.drawable.coax12));
            data.add(new STS("Coax15", R.drawable.coax15));
            data.add(new STS("Concerto SUB", R.drawable.concerto));
            data.add(new STS("infraSUB", R.drawable.infra));
            data.add(new STS("miniSUB", R.drawable.mini));
            data.add(new STS("Sonata", R.drawable.sonata));
            data.add(new STS("Concerto TOP", R.drawable.top));
            data.add(new STS("Linea V10", R.drawable.v10));
            data.add(new STS("Linea V10i", R.drawable.v10i));
            data.add(new STS("Linea V5", R.drawable.v5));
        }

        // Set up the toolbar
        setUpToolbar(view);

        // Set up the RecyclerView
        recView = view.findViewById(R.id.recView);
        recView.setHasFixedSize(true);
        recView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new STSAdapter(data);

        recView.setAdapter(adapter);

        int sidePadding = getResources().getDimensionPixelSize(R.dimen.brand_card_side_padding);
        int itemPadding = getResources().getDimensionPixelSize(R.dimen.brand_card_item_padding);
        recView.addItemDecoration(new BrandItemDecoration(sidePadding, itemPadding));

        return view;
    }
    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null)
        {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setTitle(this.brand);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

}
