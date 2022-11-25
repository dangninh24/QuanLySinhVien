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

public class CustomListClass extends RecyclerView.Adapter<CustomListClass.Viewholder> {
    public interface MyOnClickItemListener{
        void doSomeThing(int position);
    }

    MyOnClickItemListener myOnClickItemListener;

    public void setMyOnClickItemListener(MyOnClickItemListener myOnClickItemListener) {
        this.myOnClickItemListener = myOnClickItemListener;
    }

    List<ClassRoom> list;

    public CustomListClass(List<ClassRoom> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_class, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ClassRoom classRoom =  list.get(position);
        holder.img_teacher.setImageResource(classRoom.getImg());
        holder.class_id.setText(classRoom.getClass_id());
        holder.class_name.setText(classRoom.getClass_name());
        holder.teacher_name.setText(classRoom.getTeacher_name());
        holder.cardView_class.setOnClickListener(view ->{
            myOnClickItemListener.doSomeThing(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        CardView cardView_class;
        ImageView img_teacher;
        TextView class_id, class_name, teacher_name;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img_teacher = itemView.findViewById(R.id.img_class_home);
            class_id = itemView.findViewById(R.id.class_id);
            class_name = itemView.findViewById(R.id.class_name);
            teacher_name = itemView.findViewById(R.id.teacher_name);
            cardView_class = itemView.findViewById(R.id.cardview_class);
        }
    }
}
