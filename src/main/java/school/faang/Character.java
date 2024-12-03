package school.faang;

import lombok.Data;

@Data
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 0;
        this.agility = 0;
        this.intelligence = 0;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}