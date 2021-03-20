package com.simalakama.fishin.ui.profil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simalakama.fishin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profil extends Fragment {


    public static Profil newInstance() {
        return new Profil();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

}
