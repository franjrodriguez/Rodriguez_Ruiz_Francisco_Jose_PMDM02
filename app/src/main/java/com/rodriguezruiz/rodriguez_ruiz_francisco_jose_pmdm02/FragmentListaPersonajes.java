package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentListaPersonajes extends Fragment {

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos el layout para el fragment
        return inflater.inflate(R.layout.lista_personajes_fragment, container, false);
    }
}
