package com.fm.equaphonapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fm.equaphonapp.Clases.STS;
import com.fm.equaphonapp.R;

import java.util.ArrayList;

public class STSAdapter
        extends RecyclerView.Adapter<STSAdapter.STSViewHolder>
        implements View.OnClickListener
{
    private ArrayList<STS> data;
    private View.OnClickListener listener;

    public static class STSViewHolder extends RecyclerView.ViewHolder
    {
        private TextView lblSTSName;
        private ImageView imgSTS;

        public STSViewHolder(@NonNull View itemView)
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
        public void bindSTS(STS item)
        {
            lblSTSName.setText(item.getName());
            imgSTS.setImageResource(item.getImg());
        }
    }

    public STSAdapter(ArrayList<STS> data)
    {
        this.data = data;
    }
    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public STSAdapter.STSViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.sts_item, viewGroup, false);

        itemView.setOnClickListener(this);

        STSViewHolder vh = new STSViewHolder(itemView);

        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull STSAdapter.STSViewHolder STSViewHolder, int pos)
    {
        STS item = data.get(pos);
        STSViewHolder.bindSTS(item);
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
