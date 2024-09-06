package com.flutterjunction.listviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListAdapter adapter;
    private List<String> customItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);


        /*For normal listview*/
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.list_item_text, items);


        /*For normal listView*/

        /*For Custom ListView*/
        customItems = new ArrayList<String>();
        customItems.add("Item 1");
        customItems.add("Item 2");
        customItems.add("Item 3");
        customItems.add("Item 4");
        customItems.add("Item 5");
        customItems.add("Item 6");
        customItems.add("Item 7");
        customItems.add("Item 8");


        adapter = new CustomListAdapter(this, customItems);



        /*For Custom ListView*/



        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "You clicked " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
