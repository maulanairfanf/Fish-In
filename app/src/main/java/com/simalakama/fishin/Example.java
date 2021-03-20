package com.simalakama.fishin;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marlonmafra.android.widget.SegmentedTab;
import com.simalakama.fishin.adapter.TabAdapter;
import com.simalakama.fishin.ui.kategori.fragment.IkanAirLaut;
import com.simalakama.fishin.ui.kategori.fragment.IkanAirTawar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Example extends AppCompatActivity {

    @BindView(R.id.tab_kategori)
    SegmentedTab tabKategori;
    @BindView(R.id.viewpager_kategori)
    ViewPager pagerKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);

        setupTab();
    }

    private void setupTab(){
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new IkanAirTawar());
        fragmentList.add(new IkanAirLaut());
        List<String> stringList = new ArrayList<>();
        stringList.add("Ikan Air Tawar");
        stringList.add("Ikan Air Laut");

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), fragmentList);
        pagerKategori.setAdapter(tabAdapter);
        tabKategori.setupWithViewPager(pagerKategori);
        tabKategori.setup(stringList);
    }
}
