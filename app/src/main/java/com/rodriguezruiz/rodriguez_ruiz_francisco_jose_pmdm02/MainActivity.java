package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;
/**
 * Actividad principal de la aplicación que gestiona la navegación, el menú lateral,
 * las preferencias de idioma y la visualización de personajes.
 * Esta actividad implementa un sistema de navegación basado en fragmentos con DrawerLayout
 * y maneja las configuraciones de idioma a través de SharedPreferences.
 */
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.ActivityMainBinding;

import java.util.Locale;

/**
 * MainActivity actúa como el contenedor principal de la aplicación y coordina
 * la navegación entre diferentes fragmentos y la gestión de la interfaz de usuario.
 */
public class MainActivity extends AppCompatActivity {

    // Definición de cosntantes usadas en la app. Tambien serán usadas en CharacterDetailFragment.java
    public static final String IMAGE_DETAIL = "imageDetail";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String SKILLS = "skills";
    public static final String DETAIL = "detail";
    public static final String LANGUAGE = "language";
    public static final String LANGUAGE_DEFAULT = "es";

    // Descripcion de los atributos de la clase:
    //  - navController: Controlador de navegación para gestionar la misma entre fragmentos
    //  - toggle: Permite controlar el menú lateral
    //  - binding: Lleva a cabo la vinculación para acceder a las vistas de la activity
    private NavController navController;
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;

    /**
     * Método llamado cuando se crea la actividad.
     * Inicializa la interfaz de usuario, configura la navegación y establece el idioma.
     *
     * @param savedInstanceState Estado guardado de la instancia si está siendo recreada
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Proceder a cargar el idioma seleccionado en las SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String languageCode = preferences.getString(LANGUAGE, LANGUAGE_DEFAULT);
        setLocale(languageCode);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Implementar Toolbar
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        // Configurar el icono del menu en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_app);
        }

        // Obtener el NavController desde el NavHostFragment.
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        // El siguiente metodo permite controlar cuando nos encontramos en un fragment permitir el regreso <--
        navController.addOnDestinationChangedListener(this::onChangeView);

        // Configuracion del DrawLayout y el Toggle
        configToggleMenu();
        toggle.setDrawerIndicatorEnabled(true);

        // Configuracion de la navegacion
        configNavigation();

        // Configurar el icono del menu en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Maneja los cambios de vista en la navegación.
     * Controla la visibilidad del indicador del menú lateral según el fragmento actual.
     *
     * @param navController Controlador de navegación
     * @param navDestination Destino de navegación actual
     * @param bundle Argumentos adicionales de navegación
     */
    private void onChangeView(NavController navController, NavDestination navDestination, Bundle bundle) {
        // Lo primero que hacemos es verificar que toggle no está a null, en cuyo caso lanzamos configToggleMenu()
        // para que lo cree.
        if (toggle == null) {
            configToggleMenu();
        }
        // Ahora verificamos si nos encontramos en una actividad secundaria o estamos en la main
        // con la intención de eliminar el indicador del navigationdrawer y que aparezca la flecha de navegacion
        // para retornar al main o no, respectivamente.
        // En nuestro caso las dos actividades que tnemos que considerar es:
        //  - characterDetailFragment
        //  - preferencesFragment
        updateToggleState(navDestination.getId());
    }

    /**
     * Actualiza el estado del toggle y del drawer basado en el ID del destino actual.
     * Determina si debe mostrar el icono del drawer o la flecha de retorno, y si el drawer
     * debe estar bloqueado o no.
     *
     * @param destinationId El ID del destino de navegación actual
     */
    private void updateToggleState(int destinationID) {
        boolean isSecondaryFragment = (
                destinationID == R.id.characterDetailFragment ||
                destinationID == R.id.preferencesFragment
        );
        toggle.setDrawerIndicatorEnabled(!isSecondaryFragment);
        binding.drawerLayout.setDrawerLockMode(
                isSecondaryFragment ?
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED :
                        DrawerLayout.LOCK_MODE_UNLOCKED
        );
    }

    /**
     * Se llama después de que la actividad ha sido resumida.
     * Asegura que el estado del toggle esté sincronizado con el estado actual de navegación,
     * especialmente importante después de recrear la actividad.
     * Nota Adicional: El principal motivo por el que se añade este método es porque al entrar en el fragment
     *      preferencesFragment y llevar a cabo un cambio de idioma, en el momento en que se
     *      ejecuta el requireActivity().recreate() para recargar con el nuevo idioma, se mantenía el indicador
     *      por defecto del navigationdrawer (3 rayas) en lugar de la flecha para regresar a la mainActivity.
     */
    protected void onPostResume() {
        super.onPostResume();
        if (toggle != null) {
            toggle.syncState();
            // Verificar el estado actual del navigation
            NavDestination navDestination = navController.getCurrentDestination();
            if (navDestination != null) {
                updateToggleState(navDestination.getId());
            }
        }
    }

    /**
     * Crea el menú de opciones en la barra de acción.
     *
     * @param menu El menú a crear
     * @return true si el menú se creó correctamente
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    /**
     * Establece el idioma de la aplicación.
     *
     * @param languageCode Código del idioma a establecer (ejemplo: "es" para español)
     */
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    /**
     * Configura el toggle del menú lateral.
     * Inicializa y sincroniza el ActionBarDrawerToggle con el DrawerLayout.
     */
    private void configToggleMenu() {
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open_nav_drawer, R.string.close_nav_drawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Configura la navegación del menú lateral.
     * Establece los listeners para los elementos del menú y maneja la navegación.
     */
    private void configNavigation() {
        NavigationUI.setupWithNavController(binding.navigationView, navController);

        // Manejar la selección de elementos del menú
        binding.navigationView.setNavigationItemSelectedListener(menuItem -> {
            int optionItem = menuItem.getItemId();
            if (optionItem == R.id.mainFragment) {
                navController.navigate(R.id.nav_host_fragment); // Navegar al fragmento de inicio
            } else if (optionItem == R.id.nav_language) {
                navController.navigate(R.id.preferencesFragment);
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            return true;
        });
    }

    /**
     * Maneja la selección de elementos del menú de opciones.
     *
     * @param item Elemento del menú seleccionado
     * @return true si el evento fue manejado, false en caso contrario
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.menu_about) {
            showAboutDialog();
            return true;
        }        return super.onOptionsItemSelected(item);
    }

    /**
     * Gestiona la navegación hacia atrás en la aplicación.
     *
     * @return true si la navegación fue manejada, false en caso contrario
     */
    @Override
    public boolean onSupportNavigateUp() {
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = NavHostFragment.findNavController(navHostFragment);
            return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }

    /**
     * Maneja el evento de clic en un personaje.
     * Prepara y navega hacia el fragmento de detalle del personaje.
     *
     * @param characterData Datos del personaje seleccionado
     * @param view Vista que generó el evento
     */
    public void userClicked(CharacterData characterData, View view) {
//        Log.i("franlog","Acabo de entrar en userClicked");
        Bundle bundle = new Bundle();
        bundle.putInt(IMAGE_DETAIL, characterData.getImageDetailCharacter());
        bundle.putString(NAME, characterData.getNameCharacter());
        bundle.putString(DESCRIPTION, characterData.getDescriptionCharacter());
        bundle.putString(SKILLS, characterData.getSkillsCharacter());
        bundle.putString(DETAIL, characterData.getDetailCharacter());

        // Log.i("franlog", "Justo antes de navegar al fragment de detalle");
        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
    }

    /**
     * Muestra un diálogo con información sobre la aplicación.
     * Incluye derechos de autor y versión de la aplicación.
     */
    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String message = String.format("%s\n\n%s", getString(R.string.copyright), getString(R.string.version));

        builder.setTitle(R.string.about)
                .setMessage(message)
                .setIcon(R.drawable.smlogo)
                .setPositiveButton(R.string.ok_button, (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
