package com.fm.equaphonapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fm.equaphonapp.Clases.Product;
import com.fm.equaphonapp.R;

import java.util.ArrayList;

public class ProductAdapter
        extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
        implements View.OnClickListener
{
    private ArrayList<Product> data;
    private View.OnClickListener listener;

    public static class ProductViewHolder extends RecyclerView.ViewHolder
    {
        private TextView lblSTSName;
        private ImageView imgSTS;

        public ProductViewHolder(@NonNull View itemView)
        {
            super(itemView);

            lblSTSName = itemView.findViewById(R.id.lblSTSName);
            imgSTS = itemView.findViewById(R.id.imgSTS);
        }

        public ImageView getImgSTS()
        {
            return imgSTS;
        }

        public TextView getLblSTSName()
        {
            return lblSTSName;
        }

        public void setImgSTS(ImageView imgSTS)
        {
            this.imgSTS = imgSTS;
        }

        public void setLblSTSName(TextView lblSTSName)
        {
            this.lblSTSName = lblSTSName;
        }
        public void bindSTS(Product item)
        {
            lblSTSName.setText(item.getName());
            imgSTS.setImageResource(item.getImg());
        }
    }

    public ProductAdapter(ArrayList<Product> data)
    {
        this.data = data;
    }
    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.sts_item, viewGroup, false);

        itemView.setOnClickListener(this);

        ProductAdapter.ProductViewHolder vh = new ProductAdapter.ProductViewHolder(itemView);

        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder ProductViewHolder, int pos)
    {
        Product item = data.get(pos);
        ProductViewHolder.bindSTS(item);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}