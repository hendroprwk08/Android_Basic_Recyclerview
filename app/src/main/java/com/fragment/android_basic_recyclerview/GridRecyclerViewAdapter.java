package com.fragment.android_basic_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fragment.android_basic_recyclerview.databinding.ItemGridPresidentBinding;

import java.util.List;

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.CategoryViewHolder> {

    private final Context context;
    private final List<President> list; //list = variable u/ menumpuk data, yang akan disimpan kedalam class President

    public GridRecyclerViewAdapter(Context context, List<President> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GridRecyclerViewAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tempat mengenalkan atau menggunakan layout, ini baku ya... kamu cuma ubah nama layoutnya saja
        // 1. set view holder dengan binding
        ItemGridPresidentBinding binding = ItemGridPresidentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoryViewHolder holder = new CategoryViewHolder(binding.getRoot(), binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridRecyclerViewAdapter.CategoryViewHolder holder, int position) {
        //tempat memasukkan atau menampilkan data dari class President kedalam layout
        holder.binding.tvItemName.setText(list.get(position).getName());

        Glide.with(context)
                .load(list.get(position).getPhoto())
                .into(holder.binding.imgItemPhoto);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final ItemGridPresidentBinding binding;

        public CategoryViewHolder(View view, ItemGridPresidentBinding binding) {
            super(view);
            this.binding = binding;
        }
    }
}
