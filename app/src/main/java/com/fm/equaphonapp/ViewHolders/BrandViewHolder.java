package com.fm.equaphonapp.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fm.equaphonapp.Clases.Brand;
import com.fm.equaphonapp.R;

public class BrandViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    private TextView lblBrandName;
    private ImageView imgBrand;
    private View.OnClickListener listener;

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

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
