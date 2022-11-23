package com.si5b.pahlawanku;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterPahlawan extends RecyclerView.Adapter<AdapterPahlawan.ClassViewHolder>{
    private ArrayList<ModelPahlawan>datapahlawan;
    private Context ctx;

    public AdapterPahlawan(ArrayList<ModelPahlawan> datapahlawan, Context ctx) {
        this.datapahlawan = datapahlawan;
        this.ctx = ctx;
    }
    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View VW = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent,false);

        return new ClassViewHolder (VW);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelPahlawan pahlawan = datapahlawan.get(position);
        holder.tvNama.setText(pahlawan.getNama());
        holder.tvTentang.setText(pahlawan.getTentang());
        Glide
                .with(ctx)
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return datapahlawan.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
            TextView tvNama, tvTentang;
            ImageView ivFoto;

            public ClassViewHolder(@NonNull View itemView) {
                super(itemView);
                tvNama = itemView.findViewById(R.id.tv_nama);
                tvTentang = itemView.findViewById(R.id.tv_tentang);
                ivFoto = itemView.findViewById(R.id.iv_foto);

            }
        }
}

