package faang.school.javacore.abstraction;

import lombok.ToString;

@ToString
public abstract class Character {

    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int strength, int agility, int intellect) {
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    abstract void attack(Character character);
}
