package com.flutterjunction.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        /*For simple verticle list
        Comment these to use grid lists*/
        layoutManager = new LinearLayoutManager(this);

//        recyclerView.setLayoutManager(layoutManager);

        /*For simple verticle list*/


        /*For grid list Comment these to use vertical lists*/
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        /*For grid list*/

        adapter = new MyAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}