package com.declarevariable.gridview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by m on 10/21/2015.
 */
public class Adapter extends BaseAdapter {

    public static Integer[] imageId;

    private Context mContext;

    private int selectedPosition = 1;

    public Adapter(Context c, Integer[] _imageId){
        mContext = c;
        imageId = _imageId;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int arg0) {
        return imageId[arg0];
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged();
    }

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {/**/
        LayoutInflater li;
        View grid;
        if (convertView == null) {
            grid = new View(mContext);
            li = ((Activity) mContext).getLayoutInflater();
            grid = li.inflate(R.layout.grid_cell_imageview,parent,false);

        } else {
        grid = (View) convertView;
    }

    if (position == selectedPosition) {
        // grid.setSelected(true);
        // grid.setBackgroundColor(Color.parseColor("#dedede"));

        grid.setBackground(getCircularShape_day("#363636"));
    } else {
        //grid.setBackground(getCircularShape_day("#00000000"));
        grid.setBackgroundColor(Color.TRANSPARENT);
    }
    ImageView imageView = (ImageView) grid.findViewById(R.id.image);
    imageView.setImageResource(imageId[position]);

        return grid;
    }

    public static Drawable getCircularShape_day(String hexCode) {
        // this will be used to fill the rings
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor(hexCode));
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setStroke(5, Color.parseColor(hexCode));
        drawable.setSize(2 * 20 + 5, 2 * 20 + 5);
        return drawable;
    }
}