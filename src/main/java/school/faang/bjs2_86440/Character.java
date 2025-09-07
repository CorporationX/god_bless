package school.faang.bjs2_86440;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    public static final int DEFAULT_HEALTH = 100;
    public static final int BASIC_VALUES_CHARACTERISTICS = 5;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Character(String name) {
        this.name = name;
        this.strength = BASIC_VALUES_CHARACTERISTICS;
        this.agility = BASIC_VALUES_CHARACTERISTICS;
        this.intelligence = BASIC_VALUES_CHARACTERISTICS;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public abstract void attack(Character opponent);
}