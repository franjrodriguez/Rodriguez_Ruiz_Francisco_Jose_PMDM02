package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.CharacterDetailFragmentBinding;

public class CharacterDetailFragment extends Fragment {

    private CharacterDetailFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("fran", "Acabo de entrar al onViewCreated del fragment detalle");

        // Si hay argumentos los recuperamos
        if (getArguments() != null) {
            Log.i("franlog", "Estamos tomando los datos pasados");
            int image = getArguments().getInt("imageDetail");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String detail = getArguments().getString("detail");
            String skills = getArguments().getString("skills");

            // Mostramos mensaje usando un Toast
            String message = "mensaje " + " " + name;
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

            // Asignar los datos a los componentes
            binding.image.setImageResource(image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.skills.setText(skills);
        } else {
            Log.i("franlog", "OJITO!!! NO SE HAN PASADO DATOS");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.detalle_personaje);
        }
    }
}
