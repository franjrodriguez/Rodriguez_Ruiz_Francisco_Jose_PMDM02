package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

/**
 * Clase que representa los datos de un personaje en la aplicación.
 * Almacena información como imágenes, nombre, descripción, habilidades y detalles del personaje.
 *
 * @author Francisco José Rodríguez Ruiz
 * @version 1.0
 */
public class CharacterData {
    // Campos de la clase:
    //      Imagen redondeada para la lista
    //      Imagen completa del personaje para los detalles
    //      Nombre del personaje
    //      Descripción breve del mismo
    //      Habilidades de este
    //      Descripcion detallada del personaje.
    private int imageCharacter;
    private int imageDetailCharacter;
    private String nameCharacter;
    private String descriptionCharacter;
    private String skillsCharacter;
    private String detailCharacter;

    /**
     * Constructor que inicializa un nuevo objeto CharacterData con todos sus atributos.
     *
     * @param imageCharacter Identificador del recurso de la imagen principal del personaje
     * @param imageDetailCharacter Identificador del recurso de la imagen detallada del personaje
     * @param nameCharacter Nombre del personaje
     * @param descriptionCharacter Descripción breve
     * @param skillsCharacter Lista de habilidades
     * @param detailCharacter Descripción detallada
     */
    public CharacterData(int imageCharacter, int imageDetailCharacter, String nameCharacter, String descriptionCharacter, String skillsCharacter, String detailCharacter) {
        this.imageCharacter = imageCharacter;
        this.imageDetailCharacter = imageDetailCharacter;
        this.nameCharacter = nameCharacter;
        this.descriptionCharacter = descriptionCharacter;
        this.skillsCharacter = skillsCharacter;
        this.detailCharacter = detailCharacter;
    }

    // Getters de cada atributo de la clase

    public int getImageDetailCharacter() {
        return imageDetailCharacter;
    }

    public String getDetailCharacter() {
        return detailCharacter;
    }

    public int getImageCharacter() {
        return imageCharacter;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public String getDescriptionCharacter() {
        return descriptionCharacter;
    }

    public String getSkillsCharacter() {
        return skillsCharacter;
    }
}
