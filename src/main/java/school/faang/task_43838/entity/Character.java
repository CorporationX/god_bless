package school.faang.task_43838.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {

    private static final int DEFAULT_STATS = 10;

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_STATS;
        this.agility = DEFAULT_STATS;
        this.intelligence = DEFAULT_STATS;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);
}
