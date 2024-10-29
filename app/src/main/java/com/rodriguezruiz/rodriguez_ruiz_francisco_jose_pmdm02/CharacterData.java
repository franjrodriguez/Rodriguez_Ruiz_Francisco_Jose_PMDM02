package com.rodriguezruiz.rodriguez_ruiz_francisco_jose_pmdm02;

public class CharacterData {
    private int imageCharacter;
    private String nameCharacter;
    private String descriptionCharacter;
    private String skillsCharacter;
    private String detailCharacter;

    public CharacterData(int imageCharacter, String nameCharacter, String descriptionCharacter, String skillsCharacter, String detailCharacter) {
        this.imageCharacter = imageCharacter;
        this.nameCharacter = nameCharacter;
        this.descriptionCharacter = descriptionCharacter;
        this.skillsCharacter = skillsCharacter;
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