package school.faang.bjs2_79362;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character opponent);

    public void reduceHealth(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон не может быть отрицательным!");
        }
        this.health = Math.max(0, this.health - damage);
    }

}