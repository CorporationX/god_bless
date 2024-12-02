package school.faang.task43920.model;

import lombok.ToString;

@ToString
public abstract class Character {


    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

}
