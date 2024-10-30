package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.FragmentCharactersListBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CharactersListFragment extends Fragment {

    private FragmentCharactersListBinding binding;
    private ArrayList<CharacterData> character;
    private GameRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadCharacters();

        adapter = new GameRecyclerViewAdapter(character, getActivity());
        binding.charactersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.charactersRecyclerview.setAdapter(adapter);
    }

    private void loadCharacters() {
        ArrayList<CharacterData> characters = new ArrayList<>();

        characters.add(new CharacterData(
                R.drawable.foto1r,
                getString(R.string.mario_name),
                getString(R.string.mario_description),
                getString(R.string.mario_skills),
                getString(R.string.mario_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto2r,
                getString(R.string.luigi_name),
                getString(R.string.luigi_description),
                getString(R.string.luigi_skills),
                getString(R.string.luigi_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto3r,
                getString(R.string.peach_name),
                getString(R.string.peach_description),
                getString(R.string.peach_skills),
                getString(R.string.peach_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto4r,
                getString(R.string.bowser_name),
                getString(R.string.bowser_description),
                getString(R.string.bowser_skills),
                getString(R.string.bowser_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto5r,
                getString(R.string.yoshi_name),
                getString(R.string.yoshi_description),
                getString(R.string.yoshi_skills),
                getString(R.string.yoshi_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto6r,
                getString(R.string.toad_name),
                getString(R.string.toad_description),
                getString(R.string.toad_skills),
                getString(R.string.toad_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto7r,
                getString(R.string.wario_name),
                getString(R.string.wario_description),
                getString(R.string.wario_skills),
                getString(R.string.wario_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto8r,
                getString(R.string.donkey_kong_name),
                getString(R.string.donkey_kong_description),
                getString(R.string.donkey_kong_skills),
                getString(R.string.donkey_kong_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto9r,
                getString(R.string.koopa_troopa_name),
                getString(R.string.koopa_troopa_description),
                getString(R.string.koopa_troopa_skills),
                getString(R.string.koopa_troopa_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto10r,
                getString(R.string.goomba_name),
                getString(R.string.goomba_description),
                getString(R.string.goomba_skills),
                getString(R.string.goomba_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto11r,
                getString(R.string.daisy_name),
                getString(R.string.daisy_description),
                getString(R.string.daisy_skills),
                getString(R.string.daisy_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto12r,
                getString(R.string.rosalina_name),
                getString(R.string.rosalina_description),
                getString(R.string.rosalina_skills),
                getString(R.string.rosalina_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto13r,
                getString(R.string.toadette_name),
                getString(R.string.toadette_description),
                getString(R.string.toadette_skills),
                getString(R.string.toadette_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto14r,
                getString(R.string.waluigi_name),
                getString(R.string.waluigi_description),
                getString(R.string.waluigi_skills),
                getString(R.string.waluigi_detail)
        ));

        characters.add(new CharacterData(
                R.drawable.foto15r,
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