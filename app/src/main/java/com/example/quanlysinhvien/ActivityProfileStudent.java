package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.quanlysinhvien.databinding.ActivityProfileStudentBinding;

import java.util.ArrayList;
import java.util.List;

import datalocal.entity.Student;
import datalocal.entity.Subject;

public class ActivityProfileStudent extends AppCompatActivity {
    ActivityProfileStudentBinding binding;
    List<Subject> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String maSinhVien = bundle.getString("MaSinhVien");

        list = MainActivity.dbConnect.getSubjectDao().getListSubjectByIdStudent(maSinhVien);
        CustomListSubject customListSubject = new CustomListSubject(list);

        Student student = MainActivity.dbConnect.getStudentDao().getStudentById(maSinhVien);
        if(student != null) {
            binding.txtAddress.setText(student.getNoiSinh());
            binding.txtCccd.setText(student.getCCCD());
            binding.txtDepartment.setText(student.getKhoa());
            binding.txtDob.setText(student.getNgaySinh());
            binding.txtEmail.setText(student.getEmail());
            binding.txtPhoneNumber.setText(student.getSoDienThoai());
            binding.txtSex.setText(student.getGioiTinh());
            binding.txtStudentId.setText(student.getMaSinhVien());
            binding.txtStudentName.setText(student.getTenSinhVien());
        }

        binding.listSubject.setAdapter(customListSubject);
        binding.listSubject.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        binding.btnBackSubject.setOnClickListener(view -> {
            finish();
        });


    }
}