package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityStudent extends AppCompatActivity {
    RecyclerView list_student;
    Student student;
    Button btn_watch, btn_back;
    List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        list_student = findViewById(R.id.list_student);
        btn_watch = findViewById(R.id.btn_watch);
        btn_back = findViewById(R.id.btn_back_student);

        list = new ArrayList<>();
        list.add(new Student("Ninh1", "1", "Lớp 1", R.drawable.thaongan));
        list.add(new Student("Ninh2", "2", "Lớp 1", R.drawable.thaongan));
        list.add(new Student("Ninh3", "3", "Lớp 2", R.drawable.thaongan));
        list.add(new Student("Ninh4", "4", "Lớp 1", R.drawable.thaongan));
        list.add(new Student("Ninh5", "5", "Lớp 2", R.drawable.thaongan));
        list.add(new Student("Ninh6", "6", "Lớp 1", R.drawable.thaongan));
        list.add(new Student("Ninh7", "7", "Lớp 2", R.drawable.thaongan));
        list.add(new Student("Ninh8", "8", "Lớp 1", R.drawable.thaongan));



        CustomListStudent customListStudent = new CustomListStudent(list);
        customListStudent.setOnClickItemListener(new CustomListStudent.OnClickItemListener() {
            @Override
            public void doSomeThing(int position) {
                student = list.get(position);
            }
        });
        list_student.setAdapter(customListStudent);
        list_student.setLayoutManager(new LinearLayoutManager(this));



        btn_watch.setOnClickListener(view -> {
            StartStudent();
        });

        btn_back.setOnClickListener(view -> {
            BackActivity();
        });
    }

    private void BackActivity() {
        finish();
    }

    private void StartStudent() {
        try{
            Toast.makeText(this, student.getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ActivityProfileStudent.class);
            startActivity(intent);
            student = null;
        } catch (Exception err) {
            Toast.makeText(this, "Bạn chưa chọn sinh viên", Toast.LENGTH_SHORT).show();
        }
    }
}