package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener el NavController desde el NavHostFragment.
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        // Configuracion del DrawLayout y el Toggle
        configToggleMenu();

        // Configuracion de la navegacion
        configNavigation();

        // Configurar el icono del menu en la ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    
    private void configToggleMenu() {
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open_nav_drawer, R.string.close_nav_drawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void configNavigation() {
        NavigationUI.setupWithNavController(binding.navigationView, navController);

        // Manejar la selección de elementos del menú
        binding.navigationView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_host_fragment) {
                navController.navigate(R.id.nav_host_fragment); // Navegar al fragmento de inicio
            }
            binding.drawerLayout.closeDrawers(); // Cerrar el menú
            return true;
        });

//        // Maneja la opción de perfil del header del menú
//        ImageView profileImageView = binding.navigationView.getHeaderView(0).findViewById(R.id.image_header);
//
//        profileImageView.setOnClickListener(v -> {
//            navController.navigate(R.id.nav_language); // Navegar al fragmento de perfil
//            binding.drawerLayout.closeDrawers(); // Cerrar el menú
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
        Log.i("franlog","Acabo de entrar en userClicked");
        Bundle bundle = new Bundle();
        bundle.putInt("imageDetail", characterData.getImageDetailCharacter());
        bundle.putString("name", characterData.getNameCharacter());
        bundle.putString("description", characterData.getDescriptionCharacter());
        bundle.putString("skills", characterData.getSkillsCharacter());
        bundle.putString("detail", characterData.getDetailCharacter());

        Log.i("franlog", "Justo antes de navegar al fragment de detalle");
        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.about)
                .setMessage(R.string.copy)
                .setIcon(R.drawable.smlogo)
                .setPositiveButton("", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
