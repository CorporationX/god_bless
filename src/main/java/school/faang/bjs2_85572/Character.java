package school.faang.bjs2_85572;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = DefaultParameters.INITIAL_HP;

    public Character(String name) {
        this.name = name;
        this.strength = DefaultParameters.CHARACTER_STRENGTH;
        this.agility = DefaultParameters.CHARACTER_AGILITY;
        this.intelligence = DefaultParameters.CHARACTER_INTELLIGENCE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected boolean isDead(Character opponent) {
        return opponent.getHealth() > DefaultParameters.DEAD_HP;
    }

    protected void printStatusHp(Character opponent) {
        if (opponent.getHealth() > 0) {
            System.out.println("Enemy is live! Attack!");
        } else {
            System.out.println("Enemy is die, attacking is pointless");
        }
    }
}