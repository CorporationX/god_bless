package faang.school.godbless.BJS2_18915;

import lombok.ToString;

@ToString
public abstract class Character {
    private String name;
    int strength;
    int agility;
    int health = 100;
    int intelligence;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

}
