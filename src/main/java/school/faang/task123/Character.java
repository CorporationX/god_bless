package school.faang.task123;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public abstract class Character {

    private String name ;
    @Getter
    private int strength;
    @Getter
    private int agility;
    private int intelligence;
    @Getter
    @Setter
    private int health=100;

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
