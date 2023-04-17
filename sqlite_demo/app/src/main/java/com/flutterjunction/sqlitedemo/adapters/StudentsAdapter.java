package com.flutterjunction.sqlitedemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.flutterjunction.sqlitedemo.R;
import com.flutterjunction.sqlitedemo.models.Students;

import java.util.List;

//public class StudentsAdapter extends ArrayAdapter<Students> {

//    Context context;
//    int layoutRes;
//    List<Students> studentsList;
//
//
//    public StudentsAdapter(Context context, int layoutRes, List<Students> studentsList) {
//        super(context, layoutRes, studentsList);
//
//        this.context = context;
//        this.layoutRes = layoutRes;
//        this.studentsList = studentsList;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(layoutRes, null);
//
//        TextView textViewName = view.findViewById(R.id.textViewViewStudent);
//        TextView textViewDept = view.findViewById(R.id.textViewDepartment);
//        TextView textViewGPA = view.findViewById(R.id.textViewGpa);
//        TextView textViewJoin = view.findViewById(R.id.textViewJoiningDate);
//
//
//        Students students = studentsList.get(position);
//        textViewName.setText(students.getName());
//        textViewDept.setText(students.getDept());
//        textViewGPA.setText(String.valueOf(students.getGpa()));
//        textViewJoin.setText(students.getJoinDate());
//
//
//        return view;
//    }
//}
