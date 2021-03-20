package com.simalakama.fishin.ui.beranda.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.beranda.model.ItemTerbaik;
import com.simalakama.fishin.ui.beranda.model.ItemTerbaru;

import java.util.ArrayList;

import static com.simalakama.fishin.ui.beranda.Beranda.getItemTerbaik;
import static com.simalakama.fishin.ui.beranda.Beranda.getItemTerbaru;

public class BerandaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> list;
    private final int TERBAIK = 1;
    private final int TERBARU = 2;

    public BerandaAdapter(Context context, ArrayList<Object> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (i) {
            case TERBAIK:
                view = inflater.inflate(R.layout.recycler_beranda, viewGroup, false);
                holder = new TerbaikViewHolder(view);
                break;
            case TERBARU:
                view = inflater.inflate(R.layout.recycler_beranda, viewGroup, false);
                holder = new TerbaruViewHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.recycler_beranda, viewGroup, false);
                holder = new TerbaruViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == TERBAIK)
            terbaikView((TerbaikViewHolder) viewHolder);
        else if (viewHolder.getItemViewType() == TERBARU)
            terbaruView((TerbaruViewHolder) viewHolder);
    }

    private void terbaikView(TerbaikViewHolder viewHolder) {
        ItemTerbaikAdapter adapter = new ItemTerbaikAdapter(getItemTerbaik());
        viewHolder.recyclerItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        viewHolder.recyclerItem.setAdapter(adapter);
        viewHolder.judul.setText("HARGA TERBAIK");
        viewHolder.lihatSemua.setText("Lihat Semua");
    }

    private void terbaruView(TerbaruViewHolder viewHolder) {
        ItemTerbaruAdapter adapter = new ItemTerbaruAdapter(getItemTerbaru());
        viewHolder.recyclerItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        viewHolder.recyclerItem.setAdapter(adapter);
        viewHolder.judul.setText("PRODUK TERBARU");
        viewHolder.lihatSemua.setText("Lihat Semua");
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof ItemTerbaik)
            return TERBAIK;
        if (list.get(position) instanceof ItemTerbaru)
            return TERBARU;
        return -1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TerbaruViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerItem;
        TextView judul, lihatSemua;

        TerbaruViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
            judul = itemView.findViewById(R.id.txt_judul);
            lihatSemua = itemView.findViewById(R.id.txt_lihat_semua);
        }
    }

    public class TerbaikViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerItem;
        TextView judul, lihatSemua;

        TerbaikViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerItem = itemView.findViewById(R.id.recycler_item);
            judul = itemView.findViewById(R.id.txt_judul);
            lihatSemua = itemView.findViewById(R.id.txt_lihat_semua);
        }
    }
}
