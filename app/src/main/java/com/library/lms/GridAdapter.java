package com.library.lms;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<GridData> {
    Context context;
    ArrayList<GridData> list;

    public GridAdapter(Context context, ArrayList<GridData> list) {
        super(context, R.layout.grid_layout, R.id.gridView, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View current = convertView;

        if (current == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            current = inflater.inflate(R.layout.grid_layout, parent, false);
        }

        GridData obj = list.get(position);

        ImageView img = current.findViewById(R.id.grid_img);
        img.setImageResource(obj.getImg());

        TextView text = current.findViewById(R.id.grid_text);
        text.setText(obj.getText());

        return current;
    }
}
