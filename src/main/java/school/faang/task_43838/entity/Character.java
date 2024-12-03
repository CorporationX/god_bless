package school.faang.task_43838.entity;

import lombok.Data;

@Data
public abstract class Character {

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private final int health = 100;
    private int healthAfterDamageTaken;

    public Character(String name) {
        this.name = name;
        this.strength = 10;
        this.agility = 10;
        this.intelligence = 10;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
