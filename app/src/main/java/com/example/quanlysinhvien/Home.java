package com.example.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quanlysinhvien.databinding.FragmentHomeBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import datalocal.entity.Account;
import datalocal.entity.ClassRoom;
import datalocal.entity.Student;
import datalocal.entity.Teacher;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ACCOUNT = "account";
    private static Home home;

    FragmentHomeBinding binding;
    ClassRoom classRoom;

    // TODO: Rename and change types of parameters
    private Account account;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(Account account) {
        home = new Home();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ACCOUNT, account);
        home.setArguments(bundle);
        return home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (home.getArguments() != null) {
            account = (Account) home.getArguments().getSerializable(ACCOUNT);
        }
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Teacher teacher = MainActivity.dbConnect.getTeacherDao().getTeacherByAccount(account.getTaiKhoan());
        if(teacher != null) {
            binding.txtName.setText(teacher.getTenGiaoVien());
            if(teacher.getAnhGiaoVien() == R.drawable.thaongan) {
                binding.imgTeacherHome.setImageResource(R.drawable.thaongan);
                binding.imgTeacher.setImageResource(R.drawable.thaongan);
            }
        }

        List<ClassRoom> list;
        list = MainActivity.dbConnect.getClassRoomDao().getListClassRoom(account.getTaiKhoan());
        CustomListClass customListClass = new CustomListClass(list);
        customListClass.setMyOnClickItemListener(new CustomListClass.MyOnClickItemListener() {
            @Override
            public void doSomeThing(int position) {
                classRoom = list.get(position);
            }
        });
        binding.listClass.setAdapter(customListClass);
        binding.listClass.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.btnWatch.setOnClickListener(view -> {
            StartClass();
        });

    }

    private void StartClass() {
        if(classRoom != null){
            Intent intent = new Intent(getContext(), ActivityStudent.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("ClassRoom",  classRoom);
            intent.putExtras(bundle);
            startActivity(intent);
            classRoom = null;
        } else {
            Toast.makeText(getContext(), "Bạn chưa chọn lớp", Toast.LENGTH_SHORT).show();
        }
    }
}
