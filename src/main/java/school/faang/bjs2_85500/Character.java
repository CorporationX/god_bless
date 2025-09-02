package school.faang.bjs2_85500;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {
    private String name;
    private int strength = 5;
    private int agility = 5;
    private int intelligence = 5;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    abstract void attack(Character opponent);
}
