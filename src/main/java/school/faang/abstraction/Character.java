package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class Character {
    private static final int DEFAULT_CHARACTER_STRENGTH = 5;
    private static final int DEFAULT_CHARACTER_AGILITY = 5;
    private static final int DEFAULT_CHARACTER_INTELLIGENCE = 5;
    private static final int DEFAULT_VALUE_HEALTH = 100;
    private static final int MIN_VALUE_HEALTH = 0;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = DEFAULT_VALUE_HEALTH;

    public Character(String name) {
        this(name, DEFAULT_CHARACTER_STRENGTH, DEFAULT_CHARACTER_AGILITY, DEFAULT_CHARACTER_INTELLIGENCE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected boolean canAttack(int health) {
        return health > MIN_VALUE_HEALTH;
    }

    protected void equateToZeroIfNegative(Character opponent) {
        if (opponent.health < MIN_VALUE_HEALTH) {
            opponent.health = MIN_VALUE_HEALTH;
        }
    }
}
