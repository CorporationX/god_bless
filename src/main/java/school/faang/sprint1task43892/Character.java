package school.faang.sprint1task43892;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int MAX_HEALTH = 100;

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = MAX_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
