package com.flutterjunction.navigation_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        TextView nameTxtView = findViewById(R.id.textViewName);
        TextView genderTxtView = findViewById(R.id.txtViewGender);
        Button button=findViewById(R.id.buttonSecond);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String gender = i.getStringExtra("gender");

        nameTxtView.setText(name);
        genderTxtView.setText(gender);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondScreen.this, MainActivity.class);
                intent.putExtra("result", "This is a message");
                setResult(RESULT_OK,intent);
                finish();
            }
        });



    }
}