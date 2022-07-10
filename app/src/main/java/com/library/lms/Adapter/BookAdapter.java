package com.library.lms.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.library.lms.R;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> list;

    public BookAdapter(Context context, ArrayList<String> list) {
        super(context, R.layout.book_list_layout, R.id.listView_books, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;

        if (currentView == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentView = inflater.inflate(R.layout.book_list_layout, parent, false);
        }

        TextView bookName = currentView.findViewById(R.id.book_name);
        bookName.setText(list.get(position));

        return currentView;
    }
}
