package faang.school.godbless;

import lombok.Getter;

@Getter
public abstract class Character {
    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character enemy);

    public void setHealth(int health) {
        this.health = health;
    }
}
