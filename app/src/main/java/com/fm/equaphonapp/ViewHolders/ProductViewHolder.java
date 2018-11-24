package com.fm.equaphonapp.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fm.equaphonapp.Clases.Product;
import com.fm.equaphonapp.R;

public class ProductViewHolder extends RecyclerView.ViewHolder
{
    private TextView lblProductName;
    private ImageView imgProduct;

    public ProductViewHolder(@NonNull View itemView)
    {
        super(itemView);

        lblProductName = itemView.findViewById(R.id.lblSTSName);
        imgProduct = itemView.findViewById(R.id.imgSTS);
    }

    public ImageView getImgSTS()
    {
        return imgProduct;
    }

    public TextView getLblSTSName()
    {
        return lblProductName;
    }

    public void setImgSTS(ImageView imgSTS)
    {
        this.imgProduct = imgSTS;
    }

    public void setLblSTSName(TextView lblSTSName)
    {
        this.lblProductName = lblSTSName;
    }
    public void bindSTS(Product item)
    {
        lblProductName.setText(item.getName());
        imgProduct.setImageResource(item.getImg());
    }
}
