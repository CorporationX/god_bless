package ru.task_43860;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private int strength;
    private int dexterity;
    private int intelligence;
    private String name;
    private int health = 100;

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);

}
