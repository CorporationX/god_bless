package school.faang;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private String strength;
    private String dexterity;
    private String intelligence;
    private String health = "100";

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, String strength, String dexterity, String intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void attack(Character character) {
    }
}
