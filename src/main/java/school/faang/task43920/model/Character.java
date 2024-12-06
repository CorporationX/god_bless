package school.faang.task43920.model;

import lombok.ToString;

@ToString
public abstract class Character {

    private static final int INITIAL_HEALTH = 100;

    protected final String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;
    protected int health = INITIAL_HEALTH;

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

}
