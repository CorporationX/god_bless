package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public abstract class Character {
    private String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected int equateToZero(Character opponent) {
        if (opponent.health < 0) {
            opponent.health = 0;
        }
        return opponent.health;
    }
}
