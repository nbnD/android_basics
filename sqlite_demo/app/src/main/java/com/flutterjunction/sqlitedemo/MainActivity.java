package com.flutterjunction.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.flutterjunction.sqlitedemo.database_helper.StudentsDatabase;

public class MainActivity extends AppCompatActivity {
    EditText etname, etcell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.etna);
        etcell = findViewById(R.id.etcell);
    }
    public void showdata(View v) {
        startActivity(new Intent(this, Data.class));
    }

    public void submit(View v) {
        String name = etname.getText()
                .toString()
                .trim();
        String cell = etcell.getText()
                .toString()
                .trim();
        try {
            StudentsDatabase db = new StudentsDatabase(this);
            db.open();
            db.creat(name, cell);
            db.close();
            Toast.makeText(MainActivity.this, "Successfully saved ", Toast.LENGTH_LONG)
                    .show();
            etname.setText("");
            etcell.setText("");
        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void edit(View v) {
        try {
            StudentsDatabase db = new StudentsDatabase(this);
            db.open();
            db.update("1", "John", "24334421");
            db.close();
            Toast.makeText(MainActivity.this, "Successfully updated", Toast.LENGTH_LONG)
                    .show();
        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void delete(View v) {
        try {
            StudentsDatabase db = new StudentsDatabase(this);
            db.open();
            db.deleteEnter("1");
            Toast.makeText(MainActivity.this, "Successfully delete", Toast.LENGTH_LONG)
                    .show();
            db.close();
        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }
}

//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    public static final String DATABASE_NAME = "student_db";
//    SQLiteDatabase mDatabase;
//    EditText editTextName, editTextGPA;
//    Spinner spinnerDepart;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
//        createTable();
//
//
//        editTextName = findViewById(R.id.editTextName);
//        editTextGPA = findViewById(R.id.editTextGpa);
//        spinnerDepart = findViewById(R.id.spinnerDepartment);
//
//        findViewById(R.id.buttonAddStudents).setOnClickListener(this);
//        findViewById(R.id.textViewViewStudent).setOnClickListener(this);
//
//
//    }
//
//    public void createTable() {
//        String sql = "CREATE TABLE if not exists students (\n" +
//                " id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
//                " name varchar(200) NOT NULL,\n" +
//                " department varchar(200) NOT NULL,\n" +
//                " gpa double NOT NULL,\n" +
//                " joiningDate datetime NOT NULL\n" +
//                ");";
//        mDatabase.execSQL(sql);
//    }
//
//    private void addStudent() {
//        String name = editTextName.getText().toString().trim();
//        String gpa = editTextGPA.getText().toString().trim();
//        String depart = spinnerDepart.getSelectedItem().toString();
//
//
//        //getting the current time for joining date
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String joiningDate = sdf.format(cal.getTime());
//
//        if (name.isEmpty()) {
//            editTextName.setError("Name cannot be empty");
//            editTextName.requestFocus();
//            return;
//        }
//        if (gpa.isEmpty()) {
//            editTextGPA.setError("GPA cannot be empty");
//            editTextGPA.requestFocus();
//            return;
//        }
//        String sql = "INSERT INTO students(name,department,gpa,joiningDate)" + "VALUES (?,?,?,?) ";
//        mDatabase.execSQL(sql, new String[]{
//                name, depart, gpa, joiningDate
//        });
//        Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.buttonAddStudents:
//                addStudent();
//                break;
//            case R.id.textViewViewStudent:
//                startActivity(new Intent(this, StudentsActivity.class));
//                break;
//
//        }
//    }
//}