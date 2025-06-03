package school.faang.Abstraction_bjs2_79182;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {
    private String name;
    @Setter
    protected int strength;
    @Setter
    protected int agility;
    @Setter
    protected int intelligence;
    @Getter
    private int health = 100;
    private static final int DEFAULT_STAT_VALUE = 5;

    Character(String name) {
        this.name = name;
        strength = DEFAULT_STAT_VALUE;
        agility = DEFAULT_STAT_VALUE;
        intelligence = DEFAULT_STAT_VALUE;
    }

    Character(String name, int age, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public abstract void attack(Character opponent);
}

