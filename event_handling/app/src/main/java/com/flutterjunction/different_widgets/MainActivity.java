package com.flutterjunction.different_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonOne);
         editTextName = findViewById(R.id.editTextName);
        Switch switchLayout = findViewById(R.id.switch1);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);


        switchLayout.setChecked(true);
        switchLayout.setTextOn("ON");
        switchLayout.setTextOn("OFF");

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
                Toast.makeText(this, editTextName.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.switch1:
                Toast.makeText(this, "This is switch", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox:
                Toast.makeText(this, "Checkbox Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}