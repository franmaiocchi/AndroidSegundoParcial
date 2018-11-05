package com.fm.equaphonapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fm.equaphonapp.Adapters.BrandAdapter;
import com.fm.equaphonapp.Clases.Brand;
import com.fm.equaphonapp.Decoration.BrandItemDecoration;
import com.fm.equaphonapp.Messages.MessageEvent;
import com.fm.equaphonapp.NavigationHost;
import com.fm.equaphonapp.R;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment
{
    private RecyclerView recView;
    private ArrayList<Brand> data;
    private BrandAdapter adapter;

    public FirstFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Datos iniciales, despues se cargaran desde la base de datos
        data = new ArrayList<Brand>();
        data.add(new Brand("Powersoft", "",  R.drawable.powersoft));
        data.add(new Brand("STS", "", R.drawable.touringseries));
        data.add(new Brand("beyerdynamic", "", R.drawable.beyer));
        data.add(new Brand("DPA", "", R.drawable.dpa));
        data.add(new Brand("Genelec", "", R.drawable.genelec));

        // Set up the toolbar
        setUpToolbar(view);

        // Set up the RecyclerView
        recView = view.findViewById(R.id.recView);
        recView.setHasFixedSize(true);
        recView.setLayoutManager(new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false));
        adapter = new BrandAdapter(data);

        adapter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String mensaje = (data.get(recView.getChildAdapterPosition(v)).getName());
                EventBus.getDefault().postSticky(new MessageEvent(mensaje));
                ((NavigationHost) getActivity()).navigateTo(new SecondFragment(), true); // Navigate to the next Fragment
            }
        });
        recView.setAdapter(adapter);

        int sidePadding = getResources().getDimensionPixelSize(R.dimen.brand_card_side_padding);
        int itemPadding = getResources().getDimensionPixelSize(R.dimen.brand_card_item_padding);
        recView.addItemDecoration(new BrandItemDecoration(sidePadding, itemPadding));

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null)
        {
            activity.setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

}
