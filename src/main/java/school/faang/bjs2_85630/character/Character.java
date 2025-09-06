package school.faang.bjs2_85630.character;

import lombok.Getter;
import lombok.ToString;

import school.faang.bjs2_85630.exception.AlreadyDefeatedException;
import school.faang.bjs2_85630.exception.DefeatedCharacterAttackException;

@Getter
@ToString
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = DEFAULT_HEALTH;

    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;
    private static final int DEFAULT_HEALTH = 100;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void decreaseHealth(int damage) {
        health = Math.max(0, health - damage);
    }

    protected static void checkPossibilityOfBattle(Character attacking, Character attacked) {
        if (attacking.getHealth() == 0) {
            throw new DefeatedCharacterAttackException("the defeated character cannot attack anymore");
        } else if (attacked.getHealth() == 0) {
            throw new AlreadyDefeatedException("cannot attack a defeated character");
        }
    }
}
