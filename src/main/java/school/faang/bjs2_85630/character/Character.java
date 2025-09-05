package school.faang.bjs2_85630.character;

import lombok.Getter;
import lombok.ToString;

import school.faang.bjs2_85630.exception.AlreadyDefeatedException;
import school.faang.bjs2_85630.exception.DefeatedCharacterAttackException;

@Getter
@ToString

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = HEALTH;

    private static final int STRENGTH = 5;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 5;
    private static final int HEALTH = 100;

    public Character(String name) {
        this.name = name;
        this.strength = STRENGTH;
        this.agility = AGILITY;
        this.intelligence = INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void decreaseHealth(int damage) {
        if (health - damage < 0) {
            health = 0;
        } else {
            health -= damage;
        }
    }

    protected static void checkPossibilityOfBattle(Character attacking, Character attacked) {
        if (attacking.getHealth() == 0) {
            throw new DefeatedCharacterAttackException("the defeated character cannot attack anymore");
        } else if (attacked.getHealth() == 0) {
            throw new AlreadyDefeatedException("cannot attack a defeated character");
        }
    }
}
