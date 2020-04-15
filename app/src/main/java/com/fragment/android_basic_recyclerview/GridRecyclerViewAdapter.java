package com.fragment.android_basic_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.CategoryViewHolder>{

    private Context context;
    private List<President> list; //list = variable u/ menumpuk data, yang akan disimpan kedalam class President

    public GridRecyclerViewAdapter(Context context, List<President> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GridRecyclerViewAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tempat mengenalkan atau menggunakan layout, ini baku ya... kamu cuma ubah nama layoutnya saja
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_president,parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull GridRecyclerViewAdapter.CategoryViewHolder holder, int position) {
        //tempat memasukkan atau menampilkan data dari class President kedalam layout
        holder.tvName.setText(list.get(position).getName());

        Glide.with(context)
                .load(list.get(position).getPhoto())
                .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        //ini tempat untuk definisikan widget (object texview dsb)
        @BindView(R.id.tv_item_name) TextView tvName;
        @BindView(R.id.img_item_photo) ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
