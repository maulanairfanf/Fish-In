package com.simalakama.fishin.ui.beranda.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.beranda.adapter.TerbaikAdapter;
import com.simalakama.fishin.ui.beranda.model.ItemTerbaik;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Terbaik extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_terbaik)
    RecyclerView recyclerItem;
    @BindView(R.id.search)
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terbaik);
        ButterKnife.bind(this);
        // Support Action Bar
        setSupportActionBar(toolbar);

        setupRecycler();

    }

    /////// Recycler View ///////
    private void setupRecycler() {
        TerbaikAdapter adapter = new TerbaikAdapter(getItemTerbaik());
        recyclerItem.setAdapter(adapter);
        recyclerItem.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerItem.setHasFixedSize(true);
    }

    public static ArrayList<ItemTerbaik> getItemTerbaik() {
        ArrayList<ItemTerbaik> list = new ArrayList<>();
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Lele", "Rp 300.000", "Rp 240.000", "30%"));
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Nila", "Rp 50.000", "Rp 25.000", "50%"));
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Bawal", "Rp 45.000", "Rp 41.500", "10%"));
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Lele", "Rp 300.000", "Rp 240.000", "30%"));
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Nila", "Rp 50.000", "Rp 25.000", "50%"));
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Bawal", "Rp 45.000", "Rp 41.500", "10%"));
        return list;
    }
}
