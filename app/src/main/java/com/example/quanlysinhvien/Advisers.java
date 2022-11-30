package com.example.quanlysinhvien;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlysinhvien.databinding.FragmentAdvisersBinding;

import java.util.List;

import datalocal.entity.Account;
import datalocal.entity.Adviser;
import datalocal.entity.ClassRoom;
import datalocal.entity.Student;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Advisers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Advisers extends Fragment {
    FragmentAdvisersBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TEACHERID = "Teacher_id";
    private static Advisers advisers;
    private String teacherId;
    TextView txt_question;
    EditText etxt_answer;
    Button btn_add_answer;

    // TODO: Rename and change types of parameters

    public Advisers() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static Advisers newInstance(String _teacherId) {
        advisers = new Advisers();
        Bundle args = new Bundle();
        args.putSerializable(TEACHERID, _teacherId);
        advisers.setArguments(args);
        return advisers;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (advisers.getArguments() != null) {
            teacherId = advisers.getArguments().getString(TEACHERID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdvisersBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoadRecycleView();
    }

    private void LoadRecycleView() {
        List<Adviser> list =  MainActivity.dbConnect.getAdviserDao().getListAdviser();
        CustomListAdviser customListAdviser = new CustomListAdviser(list);
        customListAdviser.setOnClickItemListenner(new CustomListAdviser.OnClickItemListenner() {
            @Override
            public void doSomeThing(int position) {
                Dialog dialog = new Dialog(getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_answer_the_question);
                dialog.setCancelable(true);

                getElementById(dialog);

                Window window = dialog.getWindow();
                if(window == null) {
                    return;
                }

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT); // set độ width , height của dialog lên màn hình
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Xóa bỏ khung thừa.
                Adviser adviser = list.get(position);

                txt_question.setText(adviser.getCauHoi());
                etxt_answer.setText(adviser.getCauTraLoi());
                dialog.show();
                btn_add_answer.setOnClickListener(view -> {
                    SendAnswer(adviser, dialog);
                });
            }
        });
        binding.listAdviser.setAdapter(customListAdviser);
        binding.listAdviser.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void SendAnswer(Adviser adviser, Dialog dialog) {
        try{
            String answer = etxt_answer.getText().toString();
            adviser.setCauTraLoi(answer);
            MainActivity.dbConnect.getAdviserDao().updateAdviser(adviser);
            dialog.cancel();
            LoadRecycleView();
            Toast.makeText(getContext(), "Trả lời thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception err) {
            Toast.makeText(getContext(), "Lỗi", Toast.LENGTH_SHORT).show();
        }
    }

    private void getElementById(Dialog dialog) {
        txt_question = dialog.findViewById(R.id.txt_question);
        etxt_answer = dialog.findViewById(R.id.etxt_answer);
        btn_add_answer = dialog.findViewById(R.id.btn_add_answer);
    }
}