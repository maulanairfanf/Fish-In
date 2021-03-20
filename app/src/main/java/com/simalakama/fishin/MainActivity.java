package com.simalakama.fishin;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.simalakama.fishin.ui.beranda.Beranda;
import com.simalakama.fishin.ui.kategori.Kategori;
import com.simalakama.fishin.ui.obrolan.Obrolan;
import com.simalakama.fishin.ui.pesanan.Pesanan;
import com.simalakama.fishin.ui.profil.Profil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nav_bottom)
    BottomNavigationView bottomNavigation;
    private Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_beranda:
                        selectedFragment = Beranda.newInstace();
                        break;
                    case R.id.menu_kategori:
                        selectedFragment = Kategori.newInstance();
                        break;
                    case R.id.menu_pesanan:
                        selectedFragment = Pesanan.newInstance();
                        break;
                    case R.id.menu_obrolan:
                        selectedFragment = Obrolan.newInstance();
                        break;
                    case R.id.menu_profil:
                        selectedFragment = Profil.newInstance();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_frame, selectedFragment)
                        .commit();
                return true;
            }
        });

        if (savedInstanceState == null){
            selectedFragment = Beranda.newInstace();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout_frame, selectedFragment)
                    .commit();
        }

    }

}
