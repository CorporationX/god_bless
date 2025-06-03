package school.faang.abstraction;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int healPoint = 100;

    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

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

    public void healPoint(int healPoint) {
        this.healPoint = Math.max(healPoint, 0);
    }

    public abstract void attack(Character opponent);

}

