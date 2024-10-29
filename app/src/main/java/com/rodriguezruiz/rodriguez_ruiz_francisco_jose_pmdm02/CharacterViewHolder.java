package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterData binding;

    public CharacterViewHolder(@NonNull View itemView, CharacterData binding) {
        super(itemView);
        this.binding = binding;
    }

    public void bind (CharacterData characterData) {
        binding.nameCharacter.setText(characterData.getNameCharacter();
    }
}
