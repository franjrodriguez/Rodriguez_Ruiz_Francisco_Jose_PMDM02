package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Proceder a cargar el idioma seleccionado en las SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String languageCode = preferences.getString("language", "es");
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

        // Configuracion de la navegacion
        configNavigation();

        // Configurar el icono del menu en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void onChangeView(NavController navController, NavDestination navDestination, Bundle bundle) {
        // Usamos una operación lógica para indicarle que si nos encontramos en el fragment de Detalles o en el de Preferencias
        // desactive y en caso contrario lo activa.
        if (toggle == null) return;
        if (navDestination.getId() == R.id.characterDetailFragment || navDestination.getId() != R.id.preferencesFragment) {
            toggle.setDrawerIndicatorEnabled(false);
        } else {
            toggle.setDrawerIndicatorEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    // Implementar Idioma
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    // Metodos relacionados con la implementacion del NavigationDrawer.
    private void configToggleMenu() {
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open_nav_drawer, R.string.close_nav_drawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configNavigation() {
        NavigationUI.setupWithNavController(binding.navigationView, navController);

        // Manejar la selección de elementos del menú
        binding.navigationView.setNavigationItemSelectedListener(menuItem -> {
            int optionItem = menuItem.getItemId();
            if (optionItem == R.id.nav_home) {
                navController.navigate(R.id.drawer_layout); // Navegar al fragmento de inicio
            } else if (optionItem == R.id.nav_language) {
             //   Navigation.findNavController(this.getCurrentFocus()).navigate(R.id.preferencesFragment);
                navController.navigate(R.id.preferencesFragment);
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            return true;
        });
    }

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

    @Override
    public boolean onSupportNavigateUp() {
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = NavHostFragment.findNavController(navHostFragment);
            return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
        }
        return super.onSupportNavigateUp();
    }

    public void userClicked(CharacterData characterData, View view) {
//        Log.i("franlog","Acabo de entrar en userClicked");
        Bundle bundle = new Bundle();
        bundle.putInt("imageDetail", characterData.getImageDetailCharacter());
        bundle.putString("name", characterData.getNameCharacter());
        bundle.putString("description", characterData.getDescriptionCharacter());
        bundle.putString("skills", characterData.getSkillsCharacter());
        bundle.putString("detail", characterData.getDetailCharacter());

        // Log.i("franlog", "Justo antes de navegar al fragment de detalle");
        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
    }

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
