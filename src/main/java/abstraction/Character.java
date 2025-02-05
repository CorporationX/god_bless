package abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
        this.health = 100;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(int damage) {
        health = Math.max(0, health - damage);
    }

    @Override
    public String toString() {
        return String.format("%s: strength = %d, agility = %d, intelligence = %d, health = %d",
                name, strength, agility, intelligence, health);
    }
}
