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
    private ProductViewHolder.ClickListener listener;

    public ProductViewHolder(@NonNull View itemView)
    {
        super(itemView);

        lblProductName = itemView.findViewById(R.id.lblSTSName);
        imgProduct = itemView.findViewById(R.id.imgSTS);

        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listener.onItemClick(v, getAdapterPosition());
            }
        });
    }

    public ImageView getImgProduct()
    {
        return imgProduct;
    }

    public TextView getLblProductNameName()
    {
        return lblProductName;
    }

    public void setImgProduct(ImageView imgProduct)
    {
        this.imgProduct = imgProduct;
    }

    public void setLblProductNameName(TextView lblSTSName)
    {
        this.lblProductName = lblProductName;
    }
    public void bindProduct(Product item)
    {
        lblProductName.setText(item.getName());
        imgProduct.setImageResource(item.getImg());
    }

    //Interface to send callbacks...
    public interface ClickListener{
        public void onItemClick(View view, int position);
    }

    public void setOnClickListener(ProductViewHolder.ClickListener clickListener){
        listener = clickListener;
    }

}
