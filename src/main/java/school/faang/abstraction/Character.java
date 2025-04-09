package school.faang.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int STRENGTH_VALUE = 5;
    private static final int AGILITY_VALUE = 5;
    private static final int INTELLIGENCE_VALUE = 5;

    private final String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = STRENGTH_VALUE;
        this.agility = AGILITY_VALUE;
        this.intelligence = INTELLIGENCE_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void applyDamage(int damage) {
        this.health = Math.max(this.health - damage, 0);
    }
}
