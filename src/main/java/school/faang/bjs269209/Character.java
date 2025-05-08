package school.faang.bjs269209;

import lombok.Getter;

@Getter
public abstract class Character {
    public static final int BASE_STAT_VALUE = 5;

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = BASE_STAT_VALUE;
        this.agility = BASE_STAT_VALUE;
        this.intelligence = BASE_STAT_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public void reduceHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}
