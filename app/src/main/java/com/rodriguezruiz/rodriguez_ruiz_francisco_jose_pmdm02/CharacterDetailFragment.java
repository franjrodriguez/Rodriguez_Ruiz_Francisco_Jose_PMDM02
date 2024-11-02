package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.FragmentCharacterDetailBinding;

public class CharacterDetailFragment extends Fragment {

    private FragmentCharacterDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Si hay argumentos los recuperamos
        if (getArguments() != null) {
            int image = getArguments().getInt("imagedetail");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String detail = getArguments().getString("detail");
            String skills = getArguments().getString("skills");

            // Asignar los datos a los componentes
            binding.image.setImageResource(image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.skills.setText(skills);
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
