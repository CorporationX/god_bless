package school.faang.bjs2_56422;

import lombok.ToString;

@ToString
public abstract class Character {
    protected static final int DEFAULT_HEALTH = 100;
    protected static final int BASED_VALUE = 5;
    protected final String name;
    protected final int strength;
    protected final int agility;
    protected final int intelligence;
    protected int health = DEFAULT_HEALTH;

    public Character(String name) {
        this(name, BASED_VALUE, BASED_VALUE, BASED_VALUE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(Character opponent, int damage) {
        opponent.health = opponent.health - Math.min(damage, opponent.health);
        System.out.printf("%s\'s health is %d\n", opponent.name, opponent.health);
    }
}
