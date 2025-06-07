package school.faang.bjs2_79229;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

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

    public void ensureHealthNotNegative() {
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public abstract void attack(Character opponent);
}
