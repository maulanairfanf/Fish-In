package com.simalakama.fishin.ui.kategori.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.kategori.adapter.IkanAdapter;
import com.simalakama.fishin.ui.kategori.model.Item;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class IkanAirLaut extends Fragment {

    @BindView(R.id.recycler_air_laut)
    RecyclerView recyclerItem;
    @BindView(R.id.search)
    SearchView searchView;

    public IkanAirLaut() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ikan_air_laut, container, false);
        ButterKnife.bind(this, v);

        setupRecycler();

        return v;
    }

    private void setupRecycler(){
        IkanAdapter adapter = new IkanAdapter(getItem());
        recyclerItem.setAdapter(adapter);
        recyclerItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerItem.setHasFixedSize(true);
    }

    private ArrayList<Item> getItem(){
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.bg_primary, "Ikan Bawal", 3, "Rp 50.000/kg atau Rp 1.250/ons", "(20 review)"));
        list.add(new Item(R.drawable.bg_primary, "Ikan Lele", 4, "Rp 10.000/kg atau Rp 2.250/ons", "(15 review)"));
        list.add(new Item(R.drawable.bg_primary, "Cumi - cumi", 2, "Rp 110.000/kg atau Rp 5.250/ons", "(10 review)"));
        return list;
    }

}
