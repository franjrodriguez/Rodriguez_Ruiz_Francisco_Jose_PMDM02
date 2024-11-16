package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.CharacterCardviewBinding;
import java.util.ArrayList;

/**
 * Adaptador personalizado para el RecyclerView que muestra la lista de personajes.
 * Extiende RecyclerView.Adapter y utiliza CharacterViewHolder para manejar las vistas individuales.
 * Implementa el patrón ViewBinding para el acceso a las vistas.
 *
 * @author Francisco José Rodríguez Ruiz
 * @version 1.0
 * @see RecyclerView.Adapter
 * @see CharacterViewHolder
 */
public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    // Lista de personajes que serán mostrados en el RecyclerView
    private final ArrayList<CharacterData> characters;
    // Contexto necesario para interaccionar con la mainactivity
    private final Context context;

    /**
     * Constructor del adaptador.
     * Inicializa la lista de personajes y el contexto necesario para la interacción.
     *
     * @param characters ArrayList con los datos de los personajes a mostrar
     * @param context Contexto de la aplicación, típicamente la actividad principal
     */
    public CharacterRecyclerViewAdapter(ArrayList<CharacterData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    /**
     * Crea y devuelve un nuevo ViewHolder para una vista de personaje.
     * Se llama cuando el RecyclerView necesita crear un nuevo ViewHolder.
     *
     * @param parent El ViewGroup padre en el que se añadirá la nueva vista
     * @param viewType El tipo de vista del nuevo ViewHolder
     * @return Un nuevo CharacterViewHolder que contiene la vista de un elemento de la lista
     */
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterCardviewBinding binding = CharacterCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding);
    }

    /**
     * Vincula los datos de un personaje con un ViewHolder existente.
     * Se llama para mostrar los datos en una posición específica.
     *
     * @param holder El ViewHolder que debe actualizarse
     * @param position La posición del elemento dentro del conjunto de datos del adaptador
     */
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);

        // Hace la llamada al evento onClick
        holder.itemView.setOnClickListener(view->itemClicked(currentCharacter, view));
    }

    /**
     * Devuelve el número total de elementos en el conjunto de datos.
     *
     * @return El número total de personajes en la lista
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }

    /**
     * Maneja el evento de clic en un elemento del RecyclerView.
     * Delega el manejo del clic a la actividad principal.
     *
     * @param currentCharacter El personaje asociado al elemento clicado
     * @param view La vista que fue clicada
     */
    private void itemClicked(CharacterData currentCharacter, View view) {
        Log.i("franlog", "Se ha detectado un itemClicked");
        ((MainActivity) context).userClicked(currentCharacter, view);
    }
}
