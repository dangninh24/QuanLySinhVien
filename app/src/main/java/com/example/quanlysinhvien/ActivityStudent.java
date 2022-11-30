package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.quanlysinhvien.databinding.ActivityStudentBinding;

import java.util.List;

import datalocal.entity.ClassRoom;
import datalocal.entity.Student;

public class ActivityStudent extends AppCompatActivity {
    ActivityStudentBinding binding;
    Student student;
    List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ClassRoom classRoom = (ClassRoom) bundle.getSerializable("ClassRoom");
        list = MainActivity.dbConnect.getStudentDao().getListStudentByClass(classRoom.getMaLop());

        CustomListStudent customListStudent = new CustomListStudent(list, classRoom);
        customListStudent.setOnClickItemListener(new CustomListStudent.OnClickItemListener() {
            @Override
            public void doSomeThing(int position) {
                student = list.get(position);
            }
        });
        binding.listStudent.setAdapter(customListStudent);
        binding.listStudent.setLayoutManager(new LinearLayoutManager(this));


        binding.btnWatch.setOnClickListener(view -> {
            StartStudent();
        });

        binding.btnBackStudent.setOnClickListener(view -> {
            BackActivity();
        });
    }

    private void BackActivity() {
        finish();
    }

    private void StartStudent() {
        if(student != null) {
            Intent intent = new Intent(this, ActivityProfileStudent.class);
            Bundle bundle = new Bundle();
            bundle.putString("MaSinhVien", student.getMaSinhVien());
            intent.putExtras(bundle);
            startActivity(intent);
            student = null;
        } else {
            Toast.makeText(this, "Bạn chưa chọn sinh viên", Toast.LENGTH_SHORT).show();
        }
    }
}