package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    @Setter
    private int health = 100;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character target);
}
