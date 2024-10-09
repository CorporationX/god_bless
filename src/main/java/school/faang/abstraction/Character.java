package school.faang.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    private String name;
    int strength;
    int agility;
    int intelligence;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this(name);
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character enemy);
}
