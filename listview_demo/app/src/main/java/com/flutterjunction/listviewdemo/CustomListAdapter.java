package com.flutterjunction.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private List<String> items;

    public CustomListAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_items, parent, false);
        }

        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        String item = items.get(position);
        textViewTitle.setText(item);
        imageView.setImageResource(R.mipmap.ic_launcher_round);

        return convertView;
    }
}

