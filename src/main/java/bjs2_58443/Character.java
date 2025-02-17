package bjs2_58443;

import lombok.Getter;

@Getter
public abstract class Character {
    private final int defaultHealth = 100;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = defaultHealth;

    public Character(String name) {
        this(name, 10, 10, 10);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public void reduceHealth(int damage) {
        health = damage > health ? 0 : health - damage;
    }

    public boolean isDead() {
        return this.health == 0;
    }
}
