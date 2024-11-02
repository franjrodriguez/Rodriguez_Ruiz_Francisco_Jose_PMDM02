package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // El ActivityMainBinding nos permite inflar la pantalla de forma automática sin tener que
        // hacer uso del típico findbyid para cada objeto de la Activity.
        // Para poder hacer uso del mismo, previamente hemos tenido que indicarlo en el archivo
        // build.gradle.kts (:app), añadiendo la linea viewBinding = true
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ahora se procede a configurar el controlador de navegacion
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

    }

    public void userClicked(CharacterData characterData, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("imagedetail", characterData.getImageDetailCharacter());
        bundle.putString("name", characterData.getNameCharacter());
        bundle.putString("description", characterData.getDescriptionCharacter());
        bundle.putString("skills", characterData.getSkillsCharacter());
        bundle.putString("detail", characterData.getDetailCharacter());

        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}