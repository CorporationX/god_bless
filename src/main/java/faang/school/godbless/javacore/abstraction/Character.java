package faang.school.godbless.javacore.abstraction;

import lombok.Getter;

public abstract class Character {

    public static final int DEFAULT_HEALTH_VALUE = 100;

    protected int strength;
    protected int agility;
    private String name;
    private int intelligence;
    @Getter
    private int health;

    protected Character(String name) {
        this.name = name;
        this.health = DEFAULT_HEALTH_VALUE;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH_VALUE;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int value) {
        health -= value;
        if (health <= 0) {
            System.out.println(name + " has died.");
        }
    }
}
