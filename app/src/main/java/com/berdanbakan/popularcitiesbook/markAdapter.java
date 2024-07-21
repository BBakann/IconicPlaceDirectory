package com.berdanbakan.popularcitiesbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.berdanbakan.popularcitiesbook.databinding.RecyclerRowBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class markAdapter extends RecyclerView.Adapter<markAdapter.markHolder> {
    ArrayList<cityMark> cityMarkArrayList;

    public markAdapter(ArrayList<cityMark> cityMarkArrayList) {
        this.cityMarkArrayList = cityMarkArrayList;
    }

    @NonNull
    @Override
    public markHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new markHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull markAdapter.markHolder holder, int position) {
        String numberedName = (position + 1) + ". " + cityMarkArrayList.get(position).name;
        holder.binding.recyclerViewTextView.setText(numberedName);

        holder.itemView.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (currentPosition != RecyclerView.NO_POSITION) {
                Intent intent = new Intent(holder.itemView.getContext(), InfoActivity.class);
                intent.putExtra("cityMark", (Serializable) cityMarkArrayList.get(currentPosition));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { // XML'İN KAÇ KEZ OLUŞACAĞINI SÖYLEYECEK MESELA BİZİM 5
        return cityMarkArrayList.size();
    }

    public class markHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public markHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
