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
import java.util.Arrays;
import java.util.List;

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

        List<CharacterData> items = Arrays.asList(
                new CharacterData(R.drawable.foto1r,"Super Mario","Un fontanero heroico que salva a la Princesa Peach y lucha contra Bowser.","Saltar, Bola de Fuego, Super Fuerza",""),
                new CharacterData(R.drawable.foto2r,"Luigi","El hermano de Mario, conocido por su mayor estatura y su traje verde.","Saltar, Salto Alto, Super Fuerza",""),
                new CharacterData(R.drawable.foto3r,"Princesa Peach","La princesa del Reino Champiñón, a menudo necesita ser rescatada.","Flotar, Magia, Liderazgo",""),
                new CharacterData(R.drawable.foto4r,"Bowser","El antagonista principal, una criatura gigante con forma de tortuga.","Aliento de Fuego, Super Fuerza, Magia",""),
                new CharacterData(R.drawable.foto5r,"Toad","Un leal asistente de la Princesa Peach.","Velocidad, Sigilo, Ayuda",""),
                new CharacterData(R.drawable.foto6r,"Yoshi","Un dinosaurio amistoso que ayuda a Mario en sus aventuras.","Ataque de Lengua, Lanzamiento de Huevos, Salto Largo",""),
                new CharacterData(R.drawable.foto7r,"Kamek","Un Magikoopa que sirve como asesor de Bowser.","Hechizos Mágicos, Transformación, Vuelo",""),
                new CharacterData(R.drawable.foto8r,"Wario","El rival de Mario con una personalidad codiciosa.","Ataque de Carrera, Caída de Cuerpo, Búsqueda de Tesoros",""),
                new CharacterData(R.drawable.foto9r,"Waluigi","El rival de Luigi, conocido por su naturaleza astuta.","Velocidad, Engaño, Agilidad",""),
                new CharacterData(R.drawable.foto10r,"Rosalina","Una guardiana del cosmos con poderes mágicos.","Magia, Manipulación de Gravedad, Poder Estelar",""),
                new CharacterData(R.drawable.foto11r,"Koopa Troopa","Un enemigo en forma de tortuga que se encuentra a menudo en los juegos de Mario.","Giro de Caparazón, Velocidad, Defensa",""),
                new CharacterData(R.drawable.foto12r,"Goomba","El enemigo más básico de la serie Mario.","Ataque de Pisotón, Sigilo",""),
                new CharacterData(R.drawable.foto13r,"Birdo","Una criatura que pone huevos y los lanza a los enemigos.","Disparo de Huevos, Natación, Agilidad",""),
                new CharacterData(R.drawable.foto14r,"Hammer Bro","Un enemigo que lanza martillos a Mario.","Lanzamiento de Martillos, Ataque Saltante, Defensa",""),
                new CharacterData(R.drawable.foto15r,"Nikki","Un personaje del juego que puede teletransportarse.","Teletransportación, Velocidad, Magia","")
        );
    }

    public void userClicked(CharacterData characterData, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("image", characterData.getImageCharacter());
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