package com.example.quanlysinhvien;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.quanlysinhvien.databinding.FragmentProfileBinding;

import datalocal.entity.Account;
import datalocal.entity.Teacher;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Profile extends Fragment {

    FragmentProfileBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ACCOUNT = "account";

    // TODO: Rename and change types of parameters
    private Account account;
    private static Profile profile;

    public Profile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Profile newInstance(Account _account) {
        profile = new Profile();
        Bundle args = new Bundle();
        args.putSerializable(ACCOUNT, _account);
        profile.setArguments(args);
        return profile;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (profile.getArguments() != null) {
            account = (Account) profile.getArguments().getSerializable(ACCOUNT);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Teacher teacher = MainActivity.dbConnect.getTeacherDao().getTeacherByAccount(account.getTaiKhoan());
        if(teacher != null){
            if(teacher.getAnhGiaoVien() == R.drawable.thaongan){
                binding.imgTeacher.setImageResource(teacher.getAnhGiaoVien());
            }
            binding.txtTeacherName.setText(teacher.getTenGiaoVien());
            binding.txtDOB.setText(teacher.getNgaySinh());
            binding.txtSex.setText(teacher.getGioiTinh());
            binding.txtAddress.setText(teacher.getNoiSinh());
            binding.txtCCCD.setText(teacher.getCCCD());
            binding.txtMarried.setText(teacher.getTinhTrangHonNhan());
            binding.txtEmail.setText(teacher.getEmail());
            binding.txtPhoneNumber.setText(teacher.getSoDienThoai());
            binding.txtEducation.setText(teacher.getTrinhDo());
            binding.txtDepartment.setText(teacher.getPhongBan());
        }
    }
}