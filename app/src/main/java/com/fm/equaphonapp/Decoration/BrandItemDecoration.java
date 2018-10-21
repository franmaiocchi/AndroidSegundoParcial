package com.fm.equaphonapp.Decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BrandItemDecoration extends RecyclerView.ItemDecoration
{
    private int sidePadding;
    private int itemPadding;

    public BrandItemDecoration(int sidePadding, int itemPadding)
    {
        this.sidePadding = sidePadding;
        this.itemPadding = itemPadding;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state)
    {
        outRect.left = sidePadding;
        outRect.right = sidePadding;
        outRect.top = itemPadding;
        outRect.bottom = itemPadding;
    }
}
