package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import com.example.quanlysinhvien.databinding.ActivityMainBinding;

import datalocal.dbconnect.DBConnect;
import datalocal.entity.Account;
import datalocal.entity.AccountAndTeacher;
import datalocal.entity.ClassRoom;
import datalocal.entity.Student;
import datalocal.entity.Teacher;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public static DBConnect dbConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbConnect = Room.databaseBuilder(this, DBConnect.class, "QLSV")
                .allowMainThreadQueries()
                .build();

        binding.cboxPass.setOnCheckedChangeListener((compoundButton, check) -> {
            ShowPassword(check);
        });

        binding.btnLogin.setOnClickListener(view -> {
            Login();
        });

        binding.etxtPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    binding.txtError.setText("");
                }
            }
        });
    }

    private void Login() {

//        Account accs = new Account("GV1", "1");
//        dbConnect.getAccountDao().insertAccount(accs);
//        Teacher teacher = new Teacher("GV1",
//                "Dương Thảo Ngân",
//                R.drawable.thaongan,
//                "06/08/2001",
//                "Nữ",
//                "Sóc Sơn - Hà Nội",
//                "123456789",
//                "Chưa kết hôn",
//                "1234567890",
//                "Thạc Sĩ", "Quản Lý Khoa Học", "thaoNgan06082001@gmail.com");
//        dbConnect.getTeacherDao().insertTeacher(teacher);
//        ClassRoom classRoom1 = new ClassRoom("L01", "Lớp HTTT", "GV1", R.drawable.thaongan);
//        ClassRoom classRoom2 = new ClassRoom("L02", "Lớp CNTT", "GV1", R.drawable.thaongan);
//        dbConnect.getClassRoomDao().insertClassRoom(classRoom1);
//        dbConnect.getClassRoomDao().insertClassRoom(classRoom2);
//        Student student1 = new Student("SV01", "Đặng Đình Ninh", R.drawable.thaongan, "L01", "24/05/2001", "Nam", "Hà Nội", "1234567890", "0367052757", "dangninh24052001@gmail.com", "HTTT");
//        Student student2 = new Student("SV02", "Đặng Đình Ninh", R.drawable.thaongan, "L01", "24/05/2001", "Nam", "Hà Nội", "1234567890", "0367052757", "dangninh24052001@gmail.com", "HTTT");
//        Student student3 = new Student("SV03", "Đặng Đình Ninh", R.drawable.thaongan, "L01", "24/05/2001", "Nam", "Hà Nội", "1234567890", "0367052757", "dangninh24052001@gmail.com", "HTTT");
//        Student student4 = new Student("SV04", "Đặng Đình Ninh", R.drawable.thaongan, "L01", "24/05/2001", "Nam", "Hà Nội", "1234567890", "0367052757", "dangninh24052001@gmail.com", "HTTT");
//        Student student5 = new Student("SV05", "Đặng Đình Ninh", R.drawable.thaongan, "L01", "24/05/2001", "Nam", "Hà Nội", "1234567890", "0367052757", "dangninh24052001@gmail.com", "HTTT");
//        Student student6 = new Student("SV06", "Đặng Đình Ninh", R.drawable.thaongan, "L01", "24/05/2001", "Nam", "Hà Nội", "1234567890", "0367052757", "dangninh24052001@gmail.com", "HTTT");
//        dbConnect.getStudentDao().insertStudent(student1);
//        dbConnect.getStudentDao().insertStudent(student2);
//        dbConnect.getStudentDao().insertStudent(student3);
//        dbConnect.getStudentDao().insertStudent(student4);
//        dbConnect.getStudentDao().insertStudent(student5);
//        dbConnect.getStudentDao().insertStudent(student6);
        try{
            String pass =  binding.etxtPass.getText().toString();
            String acc =  binding.etxtAcc.getText().toString();
            Account account = null;
            account = dbConnect.getAccountDao().getListAccountByAccAndPass(acc, pass);

            if(account != null) {
                Intent intent = new Intent(this, MainPage.class);
                Home home = Home.newInstance(account);
                Profile profile = Profile.newInstance(account);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Tài Khoản Hoặc Mật Khẩu Không Đúng.", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception err) {
            Toast.makeText(this, "Lỗi Truy Cập Dữ Liệu." + err.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void ShowPassword(boolean check) {
        if(!check) {
            binding.etxtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            binding.etxtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }
}