package com.flutterjunction.table_layout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import  com.flutterjunction.table_layout.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the TableLayout
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Sample data
        String[][] data = {
                {"Header 1", "Header 2", "Header 3"},
                {"Row 1, Column 1", "Row 1, Column 2", "Row 1, Column 3"},
                {"Row 2, Column 1", "Row 2, Column 2", "Row 2, Column 3"},
                // Add more rows as needed
        };

        // Loop through data and create table rows
        for (String[] row : data) {
            TableRow tableRow = new TableRow(this);
            for (String cell : row) {
                TextView textView = new TextView(this);
                textView.setText(cell);
                textView.setPadding(16, 16, 16, 16);
                textView.setBackgroundColor(Color.LTGRAY);
                textView.setTextColor(Color.BLACK);
                textView.setGravity(Gravity.CENTER);
                tableRow.addView(textView);
            }
            tableRow.setPadding(0, 0, 0, 2); // Add spacing between rows
            tableLayout.addView(tableRow);
        }
    }
}
