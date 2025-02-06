package school.faang.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract int attack(Character opponent);


    public int getHealth() {
        if (health <= 0) {
            throw new IllegalArgumentException("Персонаж погиб.");
        }
        return health;
    }
}
