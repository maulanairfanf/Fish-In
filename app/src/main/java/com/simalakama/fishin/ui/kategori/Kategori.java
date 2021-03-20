package com.simalakama.fishin.ui.kategori;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marlonmafra.android.widget.SegmentedTab;
import com.simalakama.fishin.R;
import com.simalakama.fishin.adapter.TabAdapter;
import com.simalakama.fishin.ui.kategori.fragment.IkanAirLaut;
import com.simalakama.fishin.ui.kategori.fragment.IkanAirTawar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Kategori extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_kategori)
    SegmentedTab tabKategori;
    @BindView(R.id.viewpager_kategori)
    ViewPager pagerKategori;

    public static Kategori newInstance() {
        return new Kategori();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kategori, container, false);
        ButterKnife.bind(this, v);
        // Support Action Bar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        setupTab();

        return v;
    }

    private void setupTab(){
        // Initiate data
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new IkanAirTawar());
        fragmentList.add(new IkanAirLaut());
        List<String> stringList = new ArrayList<>();
        stringList.add("Ikan Air Tawar");
        stringList.add("Ikan Air Laut");
        // Setup adapter to tab layout
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager(), fragmentList);
        pagerKategori.setAdapter(tabAdapter);
        tabKategori.setupWithViewPager(pagerKategori);
        tabKategori.setup(stringList);
    }

}
