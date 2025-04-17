package school.faang.bjs2_68323;

import lombok.Data;

@Data
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    protected static final int DEFAULT_STRENGTH = 5;
    protected static final int DEFAULT_AGILITY = 5;
    protected static final int DEFAULT_INTELLIGENCE = 5;
    protected static final int DEFAULT_HEALTH = 100;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }
}