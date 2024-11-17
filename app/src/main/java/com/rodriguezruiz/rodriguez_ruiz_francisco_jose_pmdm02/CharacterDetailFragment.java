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

/**
 * Fragment que muestra los detalles de un personaje seleccionado.
 * Utiliza View Binding para acceder a los elementos de la interfaz de usuario.
 * Recibe los datos del personaje a través de argumentos del Bundle.
 *
 * @author Francisco José Rodríguez Ruiz
 * @version 1.0
 */
public class CharacterDetailFragment extends Fragment {

    // Definición de constantes que fueron usadas en el MainActivity.java
    // para el paso de los datos del Bundle.
    public static final String IMAGE_DETAIL = "imageDetail";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String SKILLS = "skills";
    public static final String DETAIL = "detail";

    // El siguiente atributo de la clase permite acceder a todos los objetos del layout
    private CharacterDetailFragmentBinding binding;

    /**
     * Crea y devuelve la jerarquía de vistas asociada con el fragmento.
     * Inicializa el objeto binding para acceder a las vistas del layout.
     *
     * @param inflater El LayoutInflater que se utilizará para inflar las vistas
     * @param container El ViewGroup padre al que se debe adjuntar la vista del fragmento
     * @param savedInstanceState Estado previamente guardado del fragmento
     * @return La vista raíz del layout del fragmento
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Se ejecuta inmediatamente después de que onCreateView() finalice.
     * Recupera los datos del personaje desde los argumentos y los muestra en la interfaz.
     * Muestra un Toast con el nombre del personaje seleccionado.
     *
     * @param view La vista raíz del layout del fragmento
     * @param savedInstanceState Estado previamente guardado del fragmento
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Log.i("fran", "Acabo de entrar al onViewCreated del fragment detalle");

        // Si hay argumentos los recuperamos
        if (getArguments() != null) {
            //Log.i("franlog", "Estamos tomando los datos pasados");
            int image = getArguments().getInt(IMAGE_DETAIL);
            String name = getArguments().getString(NAME);
            String description = getArguments().getString(DESCRIPTION);
            String detail = getArguments().getString(DETAIL);
            String skills = getArguments().getString(SKILLS);

            // Mostramos mensaje usando un Toast del personaje seleccionado
            String message = String.format("%s %s", getString(R.string.select), name);
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

            // Asignar los datos a los componentes
            binding.image.setImageResource(image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.skills.setText(skills);
            binding.details.setText(detail);
        } else {
            Log.i("franlog", "OJITO!!! NO SE HAN PASADO DATOS");
        }
    }

    /**
     * Se ejecuta cuando el fragmento se hace visible al usuario.
     * Actualiza el título de la ActionBar con el texto "Detalle del personaje".
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.detalle_personaje);
        }
    }
}
