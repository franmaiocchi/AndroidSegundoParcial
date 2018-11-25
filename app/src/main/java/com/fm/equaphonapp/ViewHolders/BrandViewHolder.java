package com.fm.equaphonapp.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fm.equaphonapp.Clases.Brand;
import com.fm.equaphonapp.R;

public class BrandViewHolder extends RecyclerView.ViewHolder
{
    private TextView lblBrandName;
    private ImageView imgBrand;
    private BrandViewHolder.ClickListener listener;

    public BrandViewHolder(@NonNull View itemView)
    {
        super(itemView);

        lblBrandName = itemView.findViewById(R.id.lblBrandName);
        imgBrand = itemView.findViewById(R.id.imgBrand);

        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listener.onItemClick(v, getAdapterPosition());
            }
        });
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

    //Interface to send callbacks...
    public interface ClickListener{
        public void onItemClick(View view, int position);
    }

    public void setOnClickListener(BrandViewHolder.ClickListener clickListener){
        listener = clickListener;
    }

}
