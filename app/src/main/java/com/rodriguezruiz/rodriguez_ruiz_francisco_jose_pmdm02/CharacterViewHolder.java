package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.CharacterCardviewBinding;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterCardviewBinding binding;

    public CharacterViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (CharacterData characterData) {
        binding.image.setImageResource(characterData.getImageCharacter());
        binding.name.setText(characterData.getNameCharacter());
        binding.executePendingBindings();
    }
}
