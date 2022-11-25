package com.example.quanlysinhvien;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomListStudent extends RecyclerView.Adapter<CustomListStudent.Viewholder> {
    public interface OnClickItemListener{
        void doSomeThing(int position);
    }

    private OnClickItemListener onClickItemListener;
    List<Student> list;

    public CustomListStudent(List<Student> _list) {
        this.list = _list;
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_student, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Student student = list.get(position);
        Log.d("Data", student.getId() + student.getName());
        holder.img_student.setImageResource(student.getImg());
        holder.txt_class_name_student.setText(student.getClass_name());
        holder.txt_student_id.setText(student.getId());
        holder.txt_student_name.setText(student.getName());
        holder.cardview_student.setOnClickListener(view -> {
            onClickItemListener.doSomeThing(position);
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        CardView cardview_student;
        ImageView img_student;
        TextView txt_student_id, txt_student_name, txt_class_name_student;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cardview_student = itemView.findViewById(R.id.cardview_student);
            img_student = itemView.findViewById(R.id.img_student);
            txt_student_id = itemView.findViewById(R.id.txt_student_id);
            txt_student_name = itemView.findViewById(R.id.txt_student_name);
            txt_class_name_student = itemView.findViewById(R.id.txt_class_name_student);
        }
    }
}
