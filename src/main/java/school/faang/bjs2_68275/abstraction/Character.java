package school.faang.bjs2_68275.abstraction;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class Character {
    private static final int STRENGTH_DEFAULT = 5;
    private static final int AGILITY_DEFAULT = 5;
    private static final int INTELLIGENCE_DEFAULT = 5;
    private static final int HEALTH_DEFAULT = 100;

    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = HEALTH_DEFAULT;

    public Character(String name) {
        this.name = name;
        this.strength = STRENGTH_DEFAULT;
        this.agility = AGILITY_DEFAULT;
        this.intelligence = INTELLIGENCE_DEFAULT;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected boolean isHealthLessZeroAfterAttack(int health, int damage) {
        boolean result = false;
        if (health < damage) {
            result = true;
        }
        return result;
    }

    abstract void attack(Character opponent);
}
