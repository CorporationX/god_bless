package school.faang.abstraction;

import lombok.Getter;

public abstract class Character {

    protected static final int DEFAULT_HEALTH = 100;
    protected static final int DEFAULT_STRENGTH = 5;
    protected static final int DEFAULT_AGILITY = 5;
    protected static final int DEFAULT_INTELLIGENCE = 5;

    private final String name;
    @Getter
    private int strength = DEFAULT_STRENGTH;
    @Getter
    private int agility = DEFAULT_AGILITY;
    @Getter
    private int intelligence = DEFAULT_INTELLIGENCE;
    protected int health = DEFAULT_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public Character(int strength, int agility, int intelligence, String name) {
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
        this.name = name;
    }

    public abstract void attack(Character opponent);

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }
}
