package com.flutterjunction.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button,customButton,gotoSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Simple Alert
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        //Simple Alert


//        Custom Dialog
        customButton=findViewById(R.id.custom_button);
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });

//        Custom Dialog
    }
    //Simple Alert
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert!!!");
        builder.setMessage("Are you sure you want to exit?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle OK button click
                Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle Cancel button click
                Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //Simple Alert

    //Custom Dialog
    private void showCustomDialog() {
        // Inflate the dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        // Build the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(true);

        builder.setTitle("Calculate Sum");

        EditText first=dialogView.findViewById(R.id.edit_text_1);
        EditText second=dialogView.findViewById(R.id.edit_text_2);
        Button calculate=dialogView.findViewById(R.id.calculateButton);
        TextView result=dialogView.findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber,secondNumber,total;
                firstNumber=Integer.parseInt(first.getText().toString());
                secondNumber=Integer.parseInt(second.getText().toString());
                total=firstNumber+secondNumber;
                result.setText("Result is "+total);
            }
        });


        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
