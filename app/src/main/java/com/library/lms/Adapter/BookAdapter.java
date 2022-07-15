package com.library.lms.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.library.lms.DB.Books;
import com.library.lms.R;

import java.util.List;
import java.util.Locale;

public class BookAdapter extends ArrayAdapter<Books> {
    Context context;
    List<Books> list;

    public BookAdapter(Context context, List<Books> list) {
        super(context, R.layout.list_books, R.id.listView_books, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;

        if (currentView == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentView = inflater.inflate(R.layout.list_books, parent, false);
        }

        TextView bookName = currentView.findViewById(R.id.book_name);
        TextView bookAuthor = currentView.findViewById(R.id.book_author);
        TextView bookIsbn = currentView.findViewById(R.id.book_isbn);
        TextView bookTotal = currentView.findViewById(R.id.book_total);
        TextView bookAvailable = currentView.findViewById(R.id.book_available);

        bookName.setText(list.get(position).title);
        bookAuthor.setText(String.format("Author: %s", list.get(position).author));
        bookIsbn.setText(String.format(Locale.ENGLISH, "ISBN: %d ", list.get(position).isbn));
        bookTotal.setText(String.format(Locale.ENGLISH, "Total: %d", list.get(position).total));
        bookAvailable.setText(String.format(Locale.ENGLISH, "Abailable: %d", list.get(position).available));

        return currentView;
    }
}
