package derschrank.task03.bjstwo_43815;

import lombok.Data;
import lombok.Getter;

@Getter
public abstract class Character {

    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;
    protected String type = "Ghost";

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    protected void getDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (strength: %d, dexterity: %d, intelligence: %d), has health: %d",
                type, name, strength, dexterity, intelligence, health);
    }
}
