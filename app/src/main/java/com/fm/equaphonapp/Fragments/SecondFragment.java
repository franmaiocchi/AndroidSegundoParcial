package com.fm.equaphonapp.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.fm.equaphonapp.Clases.Product;
import com.fm.equaphonapp.Decoration.BrandItemDecoration;
import com.fm.equaphonapp.Messages.MessageEvent;
import com.fm.equaphonapp.NavigationHost;
import com.fm.equaphonapp.R;
import com.fm.equaphonapp.ViewHolders.ProductViewHolder;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

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
    private ArrayList<Product> data;
    private RecyclerView recView;
    private FirebaseRecyclerAdapter adapter;
    private Query query;

    @Override
    public void onStart()
    {
        super.onStart();
        adapter.startListening();
    }
    // UI updates must run on MainThread
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event)
    {
    }

    @Override
    public void onStop()
    {
        EventBus.getDefault().unregister(this);
        adapter.stopListening();
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
            this.brand = stickyEvent.firstMessage;
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
            query = FirebaseDatabase.getInstance()
                    .getReference()
                    .child(this.brand)
                    .limitToLast(50);
        }
        else
        {
            query = FirebaseDatabase.getInstance()
                    .getReference()
                    .child("STS")
                    .limitToLast(50);
        }

        // Set up the toolbar
        setUpToolbar(view);

        // Set up the RecyclerView
        recView = view.findViewById(R.id.recView);
        //recView.setHasFixedSize(true);
        recView.setLayoutManager(new GridLayoutManager(getContext(),2));

        FirebaseRecyclerOptions<Product> options =
                new FirebaseRecyclerOptions.Builder<Product>().setQuery(query, Product.class).build();

        adapter = new FirebaseRecyclerAdapter<Product, ProductViewHolder>(options)
        {
            @NonNull
            @Override
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
            {
                // Create a new instance of the ViewHolder, in this case we are using a custom
                // layout called R.layout.message for each item
                View view = LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.sts_item, parent, false);

                ProductViewHolder viewHolder = new ProductViewHolder(view);

                viewHolder.setOnClickListener(new ProductViewHolder.ClickListener()
                {
                    @Override
                    public void onItemClick(View view, int position)
                    {
                        Product item = (Product) adapter.getItem(position);
                        String mensaje = item.getName();
                        EventBus.getDefault().postSticky(new MessageEvent(brand, mensaje));
                        ((NavigationHost) getActivity()).navigateTo(new DetailFragment(), true); // Navigate to the next Fragment
                    }
                });
                return viewHolder;
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull Product model)
            {
                holder.bindProduct(model);
            }
        };

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
