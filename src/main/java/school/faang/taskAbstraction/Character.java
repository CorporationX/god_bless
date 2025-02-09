package school.faang.taskAbstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_STAT = 5;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this(name, DEFAULT_STAT, DEFAULT_STAT, DEFAULT_STAT);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character opponent);

    public static void checkHealth(Character character) {
        if (character.getHealth() == 0 || character.getHealth() < 0) {
            System.out.println("The opponent is dead.");
        } else {
            System.out.println("Current health " + character.getName() + ": " + character.getHealth() + " HP");
        }
    }
}
