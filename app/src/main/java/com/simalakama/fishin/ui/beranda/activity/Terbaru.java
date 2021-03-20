package com.simalakama.fishin.ui.beranda.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.beranda.adapter.TerbaruAdapter;
import com.simalakama.fishin.ui.beranda.model.ItemTerbaru;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Terbaru extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_terbaru)
    RecyclerView recyclerItem;
    @BindView(R.id.search)
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terbaru);
        ButterKnife.bind(this);
        // Support Action Bar
        setSupportActionBar(toolbar);

        setupRecycler();
    }

    /////// Recycler View ///////
    private void setupRecycler() {
        TerbaruAdapter adapter = new TerbaruAdapter(getItemTerbaru());
        recyclerItem.setAdapter(adapter);
        recyclerItem.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerItem.setHasFixedSize(true);
    }

    public static ArrayList<ItemTerbaru> getItemTerbaru() {
        ArrayList<ItemTerbaru> list = new ArrayList<>();
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Lele", "Rp 350.000"));
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Nila", "Rp 40.000"));
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Bawal", "Rp 250.000"));
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Lele", "Rp 450.000"));
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Nila", "Rp 150.000"));
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Bawal", "Rp 50.000"));
        return list;
    }
}
