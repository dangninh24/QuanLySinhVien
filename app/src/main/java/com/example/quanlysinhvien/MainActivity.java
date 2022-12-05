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
import datalocal.entity.Adviser;
import datalocal.entity.ClassRoom;
import datalocal.entity.Student;
import datalocal.entity.Subject;
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
        try{
            String pass =  binding.etxtPass.getText().toString();
            String acc =  binding.etxtAcc.getText().toString();
            Account account = null;
            account = dbConnect.getAccountDao().getListAccountByAccAndPass(acc, pass);

            if(account != null) {
                Intent intent = new Intent(this, MainPage.class);
                Home home = Home.newInstance(account);
                Profile profile = Profile.newInstance(account);
                Advisers advisers = Advisers.newInstance(account.getTaiKhoan());
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