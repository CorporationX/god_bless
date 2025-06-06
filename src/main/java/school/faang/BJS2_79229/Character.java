package school.faang.BJS2_79229;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    String name;
    int strength;
    int agility;
    int intelligence;
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

    public void checkZeroHealth() {
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public abstract void attack(Character opponent);
}
