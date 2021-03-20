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
import com.simalakama.fishin.ui.beranda.model.ItemTerbaik;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TerbaikAdapter extends RecyclerView.Adapter<TerbaikAdapter.ViewHolder> {

    private ArrayList<ItemTerbaik> list;

    public TerbaikAdapter(ArrayList<ItemTerbaik> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_terbaik, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ItemTerbaik itemTerbaik = list.get(i);
        viewHolder.imgItem.setImageResource(itemTerbaik.getImgItem());
        viewHolder.namaItem.setText(itemTerbaik.getNamaItem());
        viewHolder.hargaItem.setText(itemTerbaik.getHargaItem());
        viewHolder.hargaDiskon.setText(itemTerbaik.getHargaDiskon());
        viewHolder.diskonItem.setText(itemTerbaik.getDiskonItem());
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
        @BindView(R.id.txt_harga_diskon)
        TextView hargaDiskon;
        @BindView(R.id.txt_diskon)
        TextView diskonItem;
        @BindView(R.id.btn_bookmark)
        ImageButton bookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);
        }
    }
}
