package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;
/**
 * Una clase ViewHolder que representa y gestiona la vista individual de cada personaje
 * en el RecyclerView. Extiende RecyclerView.ViewHolder para manejar la vinculación
 * de datos con la vista de tarjeta de personaje.
 */
import androidx.recyclerview.widget.RecyclerView;
import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.CharacterCardviewBinding;

/**
 * CharacterViewHolder maneja la presentación visual de los datos de un personaje individual
 * en una vista de tarjeta dentro del RecyclerView.
 */
public class CharacterViewHolder extends RecyclerView.ViewHolder {

    // Objeto que permite vincular los objetos del layout con los datos del personaje
    private final CharacterCardviewBinding binding;

    /**
     * Constructor del ViewHolder que inicializa la vinculación con la vista.
     *
     * @param binding Objeto de vinculación que contiene referencias a las vistas
     *               en el layout de la tarjeta del personaje
     */
    public CharacterViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos de un personaje con las vistas correspondientes en la tarjeta.
     * Actualiza la imagen y el nombre del personaje en la vista.
     *
     * @param characterData Objeto que contiene los datos del personaje a mostrar en la vista
     */
    public void bind (CharacterData characterData) {
        binding.image.setImageResource(characterData.getImageCharacter());
        binding.name.setText(characterData.getNameCharacter());
        binding.executePendingBindings();
    }
}
