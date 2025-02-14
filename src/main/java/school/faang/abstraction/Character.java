package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hp = 100;
    private static int DEFAULT_SKILL_VALUE = 5;

    public Character(String name) {
        this.name = name;
        setStrength(DEFAULT_SKILL_VALUE);
        setAgility(DEFAULT_SKILL_VALUE);
        setIntelligence(DEFAULT_SKILL_VALUE);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);
}