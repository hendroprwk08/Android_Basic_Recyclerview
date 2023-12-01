package com.fragment.android_basic_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fragment.android_basic_recyclerview.databinding.ItemRowPresidentBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CategoryViewHolder>{

    private Context context;
    private List<President> list; //list = variable u/ menumpuk data, yang akan disimpan kedalam class President

    public RecyclerViewAdapter(Context context, List<President> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerViewAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. set view holder dengan binding
        ItemRowPresidentBinding binding = ItemRowPresidentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoryViewHolder holder = new CategoryViewHolder(binding.getRoot(), binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.CategoryViewHolder holder, int position) {
        //tempat memasukkan atau menampilkan data dari class President kedalam layout
        // 3. masukkan nilai ke objek binding
        holder.binding.tvItemName.setText(list.get(position).getName());
        holder.binding.tvItemRemarks.setText(list.get(position).getName());

        Glide.with(context)
                .load(list.get(position).getPhoto())
                .override(55,55)
                .into(holder.binding.imgItemPhoto);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 2. set ItemRowPresident disandingkan dengan Categoryview secara binding
    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemRowPresidentBinding binding;
        public CategoryViewHolder(View view, ItemRowPresidentBinding binding) {
            super(view);
            this.binding = binding;
        }
    }
}
