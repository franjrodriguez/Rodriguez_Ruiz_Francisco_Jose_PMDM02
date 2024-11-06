package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.CharactersListFragmentBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CharactersListFragment extends Fragment {

    private CharactersListFragmentBinding binding;
    private ArrayList<CharacterData> characters; // Lista de juegos
    private CharacterRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = CharactersListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Se crea un método para cargar los datos en un ArrayList
        loadCharacters();

        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.charactersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.charactersRecyclerview.setAdapter(adapter);

        // Avisamos de que ya está todo preparado y cargado con un SnackBAr
        String mensajeUsuario = getString(R.string.welcome);
        Snackbar snackbar = Snackbar.make(view, mensajeUsuario, Snackbar.LENGTH_LONG);
    }

    private void loadCharacters() {
        characters = new ArrayList<CharacterData>();

        characters.add(new CharacterData(
                R.drawable.foto1r,
                R.drawable.image1,
                getString(R.string.mario_name),
                getString(R.string.mario_description),
                getString(R.string.mario_skills),
                getString(R.string.mario_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto2r,
                R.drawable.image2,
                getString(R.string.luigi_name),
                getString(R.string.luigi_description),
                getString(R.string.luigi_skills),
                getString(R.string.luigi_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto3r,
                R.drawable.image3,
                getString(R.string.peach_name),
                getString(R.string.peach_description),
                getString(R.string.peach_skills),
                getString(R.string.peach_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto4r,
                R.drawable.image4,
                getString(R.string.bowser_name),
                getString(R.string.bowser_description),
                getString(R.string.bowser_skills),
                getString(R.string.bowser_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto5r,
                R.drawable.image5,
                getString(R.string.yoshi_name),
                getString(R.string.yoshi_description),
                getString(R.string.yoshi_skills),
                getString(R.string.yoshi_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto6r,
                R.drawable.image6,
                getString(R.string.toad_name),
                getString(R.string.toad_description),
                getString(R.string.toad_skills),
                getString(R.string.toad_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto7r,
                R.drawable.image7,
                getString(R.string.wario_name),
                getString(R.string.wario_description),
                getString(R.string.wario_skills),
                getString(R.string.wario_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto8r,
                R.drawable.image8,
                getString(R.string.donkey_kong_name),
                getString(R.string.donkey_kong_description),
                getString(R.string.donkey_kong_skills),
                getString(R.string.donkey_kong_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto9r,
                R.drawable.image9,
                getString(R.string.koopa_troopa_name),
                getString(R.string.koopa_troopa_description),
                getString(R.string.koopa_troopa_skills),
                getString(R.string.koopa_troopa_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto10r,
                R.drawable.image10,
                getString(R.string.goomba_name),
                getString(R.string.goomba_description),
                getString(R.string.goomba_skills),
                getString(R.string.goomba_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto11r,
                R.drawable.image11,
                getString(R.string.daisy_name),
                getString(R.string.daisy_description),
                getString(R.string.daisy_skills),
                getString(R.string.daisy_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto12r,
                R.drawable.image12,
                getString(R.string.rosalina_name),
                getString(R.string.rosalina_description),
                getString(R.string.rosalina_skills),
                getString(R.string.rosalina_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto13r,
                R.drawable.image13,
                getString(R.string.toadette_name),
                getString(R.string.toadette_description),
                getString(R.string.toadette_skills),
                getString(R.string.toadette_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto14r,
                R.drawable.image14,
                getString(R.string.waluigi_name),
                getString(R.string.waluigi_description),
                getString(R.string.waluigi_skills),
                getString(R.string.waluigi_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto15r,
                R.drawable.image15,
                getString(R.string.kamek_name),
                getString(R.string.kamek_description),
                getString(R.string.kamek_skills),
                getString(R.string.kamek_detail)
        ));

    }

    @Override
    public void onStart() {

        super.onStart();
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.title_app);
        }
    }
}