package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ActivityProfileStudent extends AppCompatActivity {
    RecyclerView list_subject;
    Button btn_back_subject;
    List<Subject> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student);

        list_subject = findViewById(R.id.list_subject);
        btn_back_subject = findViewById(R.id.btn_back_subject);

        list = new ArrayList<>();
        list.add(new Subject("1", "Toán cao cấp", 10000000));
        list.add(new Subject("2", "PHP", 10000000));
        list.add(new Subject("3", "C#", 10000000));
        list.add(new Subject("4", "JAVA", 10000000));
        list.add(new Subject("5", "C++", 10000000));



        CustomListSubject customListSubject = new CustomListSubject(list);

        list_subject.setAdapter(customListSubject);
        list_subject.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        btn_back_subject.setOnClickListener(view -> {
            finish();
        });
    }
}