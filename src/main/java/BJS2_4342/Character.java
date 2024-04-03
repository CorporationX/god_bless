package BJS2_4342;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int healthPoint;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.healthPoint = 100;
    }


    public abstract void attack(Character character);
}
