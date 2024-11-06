package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.content.Context;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //private NavController navController;
    NavController navController;

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

        // Menu contextual
        registerForContextMenu(this.getCurrentFocus());

        // Ahora se procede a configurar el controlador de navegacion
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

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
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(contextMenu, view, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, contextMenu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setIcon(R.drawable.marioyamigos);
            builder.setTitle(R.string.about);

            // Combina ambos mensajes en una sola cadena
            String message = getString(R.string.copy) + "\n" + getString(R.string.version);
            builder.setMessage(message);

            builder.setPositiveButton("OK", null); // null listener for simple dismissal

            AlertDialog dialog = builder.create();
            dialog.show();
//            viewDialogAbout(getApplicationContext());
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
