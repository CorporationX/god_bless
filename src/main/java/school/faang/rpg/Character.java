package school.faang.rpg;

import lombok.Getter;

@Getter
public abstract class Character {

    protected String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;
    protected int health = 100;

    protected Character(String name) {
        this(name, 5, 5, 5);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character opponent);

    protected void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }
}