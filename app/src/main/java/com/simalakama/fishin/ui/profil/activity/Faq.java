package com.simalakama.fishin.ui.profil.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.simalakama.fishin.R;
import com.simalakama.fishin.ui.profil.adapter.FaqAdapter;
import com.simalakama.fishin.ui.profil.model.ItemFaq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Faq extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_faq)
    ExpandableListView listFaq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setupList();
    }


    private void setupList(){
        HashMap<String, List<String>> faqDetail = ItemFaq.getData();
        ArrayList<String> faqHeader = new ArrayList<>(faqDetail.keySet());
        listFaq.setAdapter(new FaqAdapter(this, faqHeader, faqDetail));
        // Change arrow to right
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        listFaq.setIndicatorBounds(width - getDipsFromPixel(120),width - getDipsFromPixel(10));
    }

    public int getDipsFromPixel(float pixels)
    {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
}
