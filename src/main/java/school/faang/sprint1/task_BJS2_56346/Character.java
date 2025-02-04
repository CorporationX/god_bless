package school.faang.sprint1.task_BJS2_56346;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        strength = 5;
        agility = 5;
        intelligence = 5;
        health = 100;
    }

    protected Character(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public abstract void attack(Character opponent);
}
