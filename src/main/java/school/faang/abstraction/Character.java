package school.faang.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    protected static final int STRENGTH_VALUE_DEFAULT = 5;
    protected static final int AGILITY_VALUE_DEFAULT = 5;
    protected static final int INTELLECT_VALUE_DEFAULT = 5;

    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this(name, STRENGTH_VALUE_DEFAULT, AGILITY_VALUE_DEFAULT, INTELLECT_VALUE_DEFAULT);
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(Character opponent, int damage) {
        opponent.health = Math.max(opponent.health - damage, 0);
    }
}
