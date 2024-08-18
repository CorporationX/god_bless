package ru.kraiush.BJS218953;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {

    private String name;
    private int might;
    private int agility;
    private int intelligence;
    protected int health = 77;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int might, int agility, int intelligence) {
        this.name = name;
        this.might = might;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);
}

