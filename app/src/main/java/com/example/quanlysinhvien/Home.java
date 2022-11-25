package com.example.quanlysinhvien;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView list_class;
    ClassRoom classRoom;
    Button btn_watch;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        list_class = view.findViewById(R.id.list_class);
        btn_watch = view.findViewById(R.id.btn_watch);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<ClassRoom> list = new ArrayList<>();
        list.add(new ClassRoom(R.drawable.thaongan, "1", "Lớp 1", "Dương Thảo Ngân"));
        list.add(new ClassRoom(R.drawable.thaongan, "2", "Lớp 2", "Lươn Thảo Ngân"));

        CustomListClass customListClass = new CustomListClass(list);
        customListClass.setMyOnClickItemListener(new CustomListClass.MyOnClickItemListener() {
            @Override
            public void doSomeThing(int position) {
                classRoom = list.get(position);

            }
        });
        list_class.setAdapter(customListClass);
        list_class.setLayoutManager(new LinearLayoutManager(getContext()));

        btn_watch.setOnClickListener(view -> {
            try{
                Toast.makeText(getContext(), classRoom.getTeacher_name(), Toast.LENGTH_SHORT).show();
                classRoom = null;
            } catch (Exception err) {
                Toast.makeText(getContext(), "Bạn chưa chọn lớp", Toast.LENGTH_SHORT).show();

            }

        });

    }
}