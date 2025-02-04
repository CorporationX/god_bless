package school.faang.character.model;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        this.power = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);
}
