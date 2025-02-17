package school.faang.sprint1.abstr_abstr_58424;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class Character {
    protected final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    private int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void reduceHealth(Character opponent, int damage) {
        opponent.health = Math.max(opponent.health - damage, 0);
    }

}
