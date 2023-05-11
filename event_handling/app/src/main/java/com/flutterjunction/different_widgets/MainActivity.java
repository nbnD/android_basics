package com.flutterjunction.different_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    EditText editTextName;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonOne);
        editTextName = findViewById(R.id.editTextName);
        Switch switchLayout = findViewById(R.id.switch1);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Spinner mySpinner = findViewById(R.id.spinner);


        switchLayout.setText("hello");

        button.setOnClickListener(this);
        checkBox.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);

                Toast.makeText(MainActivity.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonOne:
                name = editTextName.getText().toString().trim();
                if (name.isEmpty()) {
                    editTextName.setError("Name cannot be empty");
                    editTextName.requestFocus();
                    return;
                }
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                break;

            case R.id.switch1:
                Toast.makeText(this, "This is switch", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox:
                Toast.makeText(this, "Checkbox Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "" + selectedItem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Not selected", Toast.LENGTH_SHORT).show();
    }
}