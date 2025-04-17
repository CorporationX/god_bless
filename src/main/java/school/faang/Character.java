package school.faang;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intellect;
    private int healthPoints;

    public static final int MAX_HEALTH = 100;

    protected Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
        this.healthPoints = MAX_HEALTH;
    }

    protected Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.healthPoints = MAX_HEALTH;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(int damage) {
        healthPoints -= damage;
        if (healthPoints < 0) {
            healthPoints = 0;
        }
    }
}