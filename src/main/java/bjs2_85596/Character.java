package bjs2_85596;

import lombok.Getter;

@Getter
public abstract class Character {

    private static final int UNIVERSAL_AGILITY = 5;
    private static final int UNIVERSAL_STRENGTH = 5;
    private static final int UNIVERSAL_INTELLIGENCE = 5;

    protected String name;
    protected int agility;
    protected int strength;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.agility = UNIVERSAL_AGILITY;
        this.strength = UNIVERSAL_STRENGTH;
        this.intelligence = UNIVERSAL_INTELLIGENCE;
    }

    public Character(String name, int agility, int strength, int intelligence) {
        this.name = name;
        this.agility = agility;
        this.strength = strength;
        this.intelligence = intelligence;

    }

    protected void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    protected abstract void attack(Character opponent);
}
