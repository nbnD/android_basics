package com.flutterjunction.sqlitedemo;


import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.flutterjunction.sqlitedemo.models.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {
    SQLiteDatabase mDatabase;
    List<Students> studentsList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);


        studentsList = new ArrayList<>();
        loadStudentsFromDatabase();
    }

    private void loadStudentsFromDatabase() {
        String sql = "SELECT * from students";

        Cursor cursorStudent = mDatabase.rawQuery(sql, null);


        if (cursorStudent.moveToFirst()) { // check if data is present or not
//            do {
//                studentsList.add(new Students(
//                        cursorStudent.getInt(0),
//                        cursorStudent.getString(1),
//                        cursorStudent.getString(2),
//                        cursorStudent.getString(3),
//                        cursorStudent.getDouble(4)
//                ));
//            } while (cursorStudent.moveToNext());

            while (cursorStudent.moveToNext()){
                studentsList.add(new Students(
                        cursorStudent.getInt(0),
                        cursorStudent.getString(1),
                        cursorStudent.getString(2),
                        cursorStudent.getString(3),
                        cursorStudent.getDouble(4)));
            }
            Log.d("TAG","data"+studentsList.get(0));
            StudentsAdapter adapter = new StudentsAdapter(this, R.layout.list_layout_students, studentsList);
            listView.setAdapter(adapter);
        }
    }
}