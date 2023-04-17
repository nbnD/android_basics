package com.flutterjunction.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Product> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.grid_view);

        itemList=new ArrayList<>() ;
        itemList.add(new Product("Shoes",R.mipmap.ic_launcher_round));
        itemList.add(new Product("Tshirts",R.mipmap.ic_launcher));
        itemList.add(new Product("Cap",R.mipmap.ic_launcher_round));



        MyAdapter adapter = new MyAdapter(this, itemList);
        gridView.setAdapter(adapter);
    }
}