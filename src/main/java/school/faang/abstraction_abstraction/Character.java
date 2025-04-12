package school.faang.abstraction_abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
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

    public void validateHealthLevel(Character opponent) {
        if (opponent.getHealth() == 0) {
            throw new RuntimeException("Health level is too low!");
        }
    }

    public abstract void attack(Character target);

    public abstract void receiveDamage(int damage);
}
