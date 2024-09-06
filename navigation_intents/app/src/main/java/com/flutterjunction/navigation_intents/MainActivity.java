package com.flutterjunction.navigation_intents;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextName;
    String name;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView resultValue;
    private ActivityResultLauncher<Intent> mGetContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonOne);
        editTextName = findViewById(R.id.editTextName);
        radioGroup = findViewById(R.id.radioGroup);
        resultValue = findViewById(R.id.resultText);
        resultValue.setText("Waiting");
        button.setOnClickListener(this);


        mGetContent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            String resultStr = data.getStringExtra("result");
                            resultValue.setText(resultStr);
                        }
                    }
                });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
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
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(MainActivity.this, SecondScreen.class);
                i.putExtra("name", name);
                i.putExtra("gender", radioButton.getText());
//                WITHOUT EXPECTING callback value from child activity

//                startActivity(i);

                /*When you navigate with data and Expect any return data from second screen*/
                mGetContent.launch(i);

                break;

        }
    }
}