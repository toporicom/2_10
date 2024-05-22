package com.mirea.kt.a2_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private ArrayList<Cars> people;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView fName, lName, age;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fName = itemView.findViewById(R.id.tvFName);
            lName = itemView.findViewById(R.id.tvLName);
            age = itemView.findViewById(R.id.tvAge);
        }
    }
    public RVAdapter(ArrayList<Cars> people) {
        this.people = people;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cars cars = people.get(position);
        holder.fName.setText(String.format("%s", "Модель: " + cars.getModel()));
        holder.lName.setText(String.format("%s", "Номер: " + cars.getNumber()));
        holder.age.setText(String.format("%s", "Год выпуска: " + cars.getAge()));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

}
