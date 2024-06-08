package faang.school.godbless.BJS2_7742;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    protected Character(String name) {
        this.name = name;
        health = 100;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        health = 100;
    }

    protected abstract void attack(Character enemy);

    public void setHealth(int health) {
        this.health = health;
    }
}
