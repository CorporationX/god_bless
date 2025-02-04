package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    @Setter
    private int health = 100;

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        checkName(name);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this(name,  5, 5, 5);
    }

    abstract void attack(Character opponent);

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else {
            health = 0;
            return false;
        }
    }

    private void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is missing");
        }
    }
}
