package com.example.quanlysinhvien;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import datalocal.entity.ClassRoom;
import datalocal.entity.Student;

public class CustomListStudent extends RecyclerView.Adapter<CustomListStudent.Viewholder> {
    public interface OnClickItemListener{
        void doSomeThing(int position);
    }

    private OnClickItemListener onClickItemListener;
    List<Student> list;
    ClassRoom classRoom;

    public CustomListStudent(List<Student> _list, ClassRoom classRoom) {
        this.list = _list;
        this.classRoom = classRoom;
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
        holder.img_student.setImageResource(student.getAnhSinhVien());
        holder.txt_class_name_student.setText(classRoom.getTenLop());
        holder.txt_student_id.setText(student.getMaSinhVien());
        holder.txt_student_name.setText(student.getTenSinhVien());
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
