package school.faang.Abstraction_bjs2_79182;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    @Getter
    private String name;
    @Getter @Setter
    private int strength;
    @Getter @Setter
    private int agility;
    @Setter
    private int intelligence;
    @Getter
    private int health = 100;

    Character(String name) {
        this.name = name;
        strength = 5;
        agility = 5;
        intelligence = 5;
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

