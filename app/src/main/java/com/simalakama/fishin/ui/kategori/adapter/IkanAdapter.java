package com.simalakama.fishin.ui.kategori.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.kategori.model.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IkanAdapter extends RecyclerView.Adapter<IkanAdapter.ViewHolder> {

    private ArrayList<Item> list;

    public IkanAdapter(ArrayList<Item> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_kategori, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = list.get(i);
        viewHolder.imgItem.setImageResource(item.getImgItem());
        viewHolder.namaItem.setText(item.getNamaItem());
        viewHolder.rateItem.setRating(item.getRatingItem());
        viewHolder.reviewItem.setText(item.getReviewItem());
        viewHolder.hargaItem.setText(item.getHargaItem());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item)
        ImageView imgItem;
        @BindView(R.id.txt_nama_item)
        TextView namaItem;
        @BindView(R.id.rate_item)
        RatingBar rateItem;
        @BindView(R.id.txt_review_item)
        TextView reviewItem;
        @BindView(R.id.txt_harga)
        TextView hargaItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
