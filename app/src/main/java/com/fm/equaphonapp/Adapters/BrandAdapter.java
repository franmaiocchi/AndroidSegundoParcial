package com.fm.equaphonapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fm.equaphonapp.Clases.Brand;
import com.fm.equaphonapp.R;

import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder>
{
    private ArrayList<Brand> data;

    public static class BrandViewHolder extends RecyclerView.ViewHolder
    {
        private TextView lblBrandName;
        private ImageView imgBrand;

        public BrandViewHolder(@NonNull View itemView)
        {
            super(itemView);

            lblBrandName = itemView.findViewById(R.id.lblBrandName);
            imgBrand = itemView.findViewById(R.id.imgBrand);
        }

        public ImageView getImgBrand()
        {
            return imgBrand;
        }

        public TextView getLblBrandName()
        {
            return lblBrandName;
        }

        public void setImgBrand(ImageView imgBrand)
        {
            this.imgBrand = imgBrand;
        }

        public void setLblBrandName(TextView lblBrandName)
        {
            this.lblBrandName = lblBrandName;
        }
        public void bindBrand(Brand item)
        {
            lblBrandName.setText(item.getName());
            imgBrand.setImageResource(item.getImage());
        }
    }

    public BrandAdapter(ArrayList<Brand> data)
    {
        this.data = data;
    }
    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public BrandAdapter.BrandViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.brand_item, viewGroup, false);

        BrandViewHolder vh = new BrandViewHolder(itemView);

        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull BrandAdapter.BrandViewHolder brandViewHolder, int pos)
    {
        Brand item = data.get(pos);
        brandViewHolder.bindBrand(item);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }
}
