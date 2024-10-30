package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.CharacterCardviewBinding;

import java.util.ArrayList;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private final ArrayList<CharacterData> characters;
    private final Context context;

    // Constructor de la clase
    public CharacterRecyclerViewAdapter(ArrayList<CharacterData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    // Método para crear el ViewHOlder
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterCardviewBinding binding = CharacterCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);
    }

    @Override
    public int getItemCount() {

        return characters.size();
    }

    private void itemClicked(CharacterData currentCharacter, View view) {
        ((MainActivity) context).userClicked(currentCharacter, view);
    }
}
