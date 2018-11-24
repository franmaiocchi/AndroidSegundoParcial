package com.fm.equaphonapp.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.fm.equaphonapp.Clases.Brand;
import com.fm.equaphonapp.Decoration.BrandItemDecoration;
import com.fm.equaphonapp.Messages.MessageEvent;
import com.fm.equaphonapp.NavigationHost;
import com.fm.equaphonapp.R;
import com.fm.equaphonapp.ViewHolders.BrandViewHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;



import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment
{
    private RecyclerView recView;
    private ArrayList<Brand> data;
    private FirebaseRecyclerAdapter adapter;

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

/*        // Datos iniciales, despues se cargaran desde la base de datos
        data = new ArrayList<Brand>();
        data.add(new Brand("Powersoft", "",  R.drawable.powersoft));
        data.add(new Brand("STS", "", R.drawable.touringseries));
        data.add(new Brand("beyerdynamic", "", R.drawable.beyer));
        data.add(new Brand("DPA", "", R.drawable.dpa));
        data.add(new Brand("Genelec", "", R.drawable.genelec));

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("brands").setValue(data);*/

        // Set up the toolbar
        setUpToolbar(view);

        // Set up the RecyclerView
        recView = view.findViewById(R.id.recView);
        // Debo sacar el setHasFixedSize porque si no no funciona!
        // recView.setHasFixedSize(true);
        recView.setLayoutManager(new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("brands")
                .limitToLast(50);

        FirebaseRecyclerOptions<Brand> options =
                new FirebaseRecyclerOptions.Builder<Brand>().setQuery(query, Brand.class).build();

        adapter = new FirebaseRecyclerAdapter<Brand, BrandViewHolder>(options)
                {
                    @NonNull
                    @Override
                    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        // Create a new instance of the ViewHolder, in this case we are using a custom
                        // layout called R.layout.message for each item
                        View view = LayoutInflater.from(parent.getContext()).
                                inflate(R.layout.brand_item, parent, false);

                        return new BrandViewHolder(view);
                    }

                    @Override
                    protected void onBindViewHolder(@NonNull BrandViewHolder holder, int position, @NonNull Brand model)
                    {
                        holder.bindBrand(model);
                    }
                };


/*        adapter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String mensaje = (data.get(recView.getChildAdapterPosition(v)).getName());
                EventBus.getDefault().postSticky(new MessageEvent(mensaje));
                ((NavigationHost) getActivity()).navigateTo(new SecondFragment(), true); // Navigate to the next Fragment
            }
        });*/
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

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        //adapter.stopListening();
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
