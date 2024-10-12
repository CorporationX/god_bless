package school.faang.abstraction;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intellect) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
