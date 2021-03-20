package com.simalakama.fishin.ui.beranda;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freegeek.android.materialbanner.IndicatorGravity;
import com.freegeek.android.materialbanner.MaterialBanner;
import com.freegeek.android.materialbanner.simple.SimpleBannerData;
import com.freegeek.android.materialbanner.simple.SimpleViewHolderCreator;
import com.freegeek.android.materialbanner.view.indicator.LinePageIndicator;
import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.beranda.model.ItemTerbaru;
import com.simalakama.fishin.ui.beranda.model.ItemTerbaik;
import com.simalakama.fishin.ui.beranda.adapter.BerandaAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Beranda extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.banner)
    MaterialBanner<SimpleBannerData> materialBanner;
    @BindView(R.id.recycler_beranda)
    RecyclerView recyclerBeranda;

    private LinePageIndicator linePageIndicator;
    private List<SimpleBannerData> dataBanner = new ArrayList<>();
    private ArrayList<Object> dataRecycler = new ArrayList<>();

    private static int[] images = {
            R.drawable.bg_primary,
            R.drawable.bg_primary,
            R.drawable.bg_primary,
    };


    public static Beranda newInstace() {
        return new Beranda();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_beranda, container, false);
        ButterKnife.bind(this, v);
        // Support Action Bar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        setupBanner();
        setupRecycler();

        return v;
    }

    /////// Banner ///////
    private void setupBanner() {
        getBannerData();
        settingLineIndicator();

        materialBanner.setPages(new SimpleViewHolderCreator(), dataBanner)
                .setIndicator(linePageIndicator)
                .setIndicatorInside(false)
                .startTurning(3000)
                .setIndicatorGravity(IndicatorGravity.CENTER);
    }

    private void getBannerData() {
        for (int i = 0; i < images.length; i++) {
            SimpleBannerData data = new SimpleBannerData();
            data.setTitle("Promo diskon ke " + (i + 1));
            data.setResId(images[i]);
            dataBanner.add(data);
        }
    }

    private void settingLineIndicator() {
        linePageIndicator = new LinePageIndicator(getActivity());
        linePageIndicator.setUnselectedColor(R.color.colorBannerUnselected);
        linePageIndicator.setUnselectedColor(R.color.colorBannerSelected);
    }


    /////// Recycler View ///////
    private void setupRecycler() {
        BerandaAdapter adapter = new BerandaAdapter(getActivity(), getAllItem());
        recyclerBeranda.setAdapter(adapter);
        recyclerBeranda.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerBeranda.setHasFixedSize(true);
        recyclerBeranda.setNestedScrollingEnabled(false);
    }

    private ArrayList<Object> getAllItem() {
        dataRecycler.add(getItemTerbaik().get(0));
        dataRecycler.add(getItemTerbaru().get(0));
        return dataRecycler;
    }

    public static ArrayList<ItemTerbaru> getItemTerbaru() {
        ArrayList<ItemTerbaru> list = new ArrayList<>();
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Lele", "150.000/kg"));
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Nila", "250.000/kg"));
        list.add(new ItemTerbaru(R.drawable.bg_primary, "Ikan Bawal", "50.000/kg"));
        return list;
    }

    public static ArrayList<ItemTerbaik> getItemTerbaik() {
        ArrayList<ItemTerbaik> list = new ArrayList<>();
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Lele", "300.000", "240.000", "30%"));
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Nila", "50.000", "25.000", "50%"));
        list.add(new ItemTerbaik(R.drawable.bg_primary, "Ikan Bawal", "45.000", "41.500", "10%"));
        return list;
    }
}
