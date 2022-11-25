package com.example.quanlysinhvien;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomListSubject extends RecyclerView.Adapter<CustomListSubject.ViewHolder> {
    public interface OnClickItemListener{
        void doSomeThing(int position);
    }
    OnClickItemListener onClickItemListener;
    List<Subject> list;

    public CustomListSubject(List<Subject> list) {
        this.list = list;
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_subject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Subject subject = list.get(position);
        holder.txt_subject_id.setText(subject.getId());
        holder.txt_subject_name.setText(subject.getName());
        holder.txt_subject_price.setText(String.valueOf(subject.getPrice()));
        holder.cardview_subject.setOnClickListener(view -> {
            onClickItemListener.doSomeThing(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_subject_price, txt_subject_name, txt_subject_id;
        CardView cardview_subject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_subject_price = itemView.findViewById(R.id.txt_subject_price);
            txt_subject_name = itemView.findViewById(R.id.txt_subject_name);
            txt_subject_id = itemView.findViewById(R.id.txt_subject_id);
            cardview_subject = itemView.findViewById(R.id.cardview_subject);
        }
    }

}
