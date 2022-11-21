package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;

import com.example.quanlysinhvien.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    private void ShowPassword(boolean check) {
        if(!check) {
            binding.etxtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            binding.etxtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }
}