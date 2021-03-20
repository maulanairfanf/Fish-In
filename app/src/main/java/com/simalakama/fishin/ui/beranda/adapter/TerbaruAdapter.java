package com.simalakama.fishin.ui.beranda.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.beranda.model.ItemTerbaru;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TerbaruAdapter extends RecyclerView.Adapter<TerbaruAdapter.ViewHolder> {

    private ArrayList<ItemTerbaru> list;

    public TerbaruAdapter(ArrayList<ItemTerbaru> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_terbaru, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ItemTerbaru itemTerbaru = list.get(i);
        viewHolder.imgItem.setImageResource(itemTerbaru.getImgItem());
        viewHolder.namaItem.setText(itemTerbaru.getNamaItem());
        viewHolder.hargaItem.setText(itemTerbaru.getHargaItem());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item)
        ImageView imgItem;
        @BindView(R.id.txt_nama_item)
        TextView namaItem;
        @BindView(R.id.txt_harga)
        TextView hargaItem;
        @BindView(R.id.btn_bookmark)
        ImageButton bookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
