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

import datalocal.entity.Adviser;
import datalocal.entity.Student;

public class CustomListAdviser extends RecyclerView.Adapter<CustomListAdviser.ViewHolder> {
    public interface OnClickItemListenner{
        void doSomeThing(int position);
    }

    private OnClickItemListenner onClickItemListenner;
    List<Adviser> list;

    public void setOnClickItemListenner(OnClickItemListenner onClickItemListenner) {
        this.onClickItemListenner = onClickItemListenner;
    }

    public CustomListAdviser(List<Adviser> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_adviser, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Adviser adviser = list.get(position);
        Student student = MainActivity.dbConnect.getStudentDao().getStudentById(adviser.getMaSinhVien());

        holder.txt_answer.setText(adviser.getCauTraLoi());
        holder.txt_question.setText(adviser.getCauHoi());
        holder.txt_student_id.setText(adviser.getMaSinhVien());
        if(student != null) {
            holder.img_student_adviser.setImageResource(student.getAnhSinhVien());
        }

        holder.cardview_adviser.setOnClickListener(view -> {
            onClickItemListenner.doSomeThing(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardview_adviser;
        ImageView img_student_adviser;
        TextView txt_question, txt_answer, txt_student_id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_student_adviser = itemView.findViewById(R.id.img_student_adviser);
            txt_question = itemView.findViewById(R.id.txt_question);
            txt_answer = itemView.findViewById(R.id.txt_answer);
            txt_student_id = itemView.findViewById(R.id.txt_student_id);
            cardview_adviser = itemView.findViewById(R.id.cardview_adviser);
        }
    }
}
