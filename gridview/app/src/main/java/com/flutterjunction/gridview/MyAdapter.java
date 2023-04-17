package com.flutterjunction.gridview;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Product> itemList;

    public MyAdapter(Context context, List<Product> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = view.findViewById(R.id.image_view);
        TextView textView = view.findViewById(R.id.text_view);

        Product item = itemList.get(position);
        imageView.setImageResource(item.getImageResId());
        textView.setText(item.getName());

        return view;
    }
}

