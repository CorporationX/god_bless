package bjs2_85596;

import lombok.Data;

@Data

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.agility = 5;
        this.intelligence = 5;
        this.strength = 5;
    }

    public Character(String name, int agility, int strength, int intelligence) {
        this.name = name;
        this.agility = agility;
        this.strength = strength;
        this.intelligence = intelligence;

    }

    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public abstract void attack(Character opponent);
}
