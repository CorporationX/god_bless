package ru.kraiush.BJS218953;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Warrior extends Character {

    private String name;
    private int might;
    private int agility;
    private int intelligence;
    private int health = super.health;

    public Warrior(String name) {
        super(name);
        this.name = name;
        might = 20;
        agility = 5;
        intelligence = 3;
    }

    public Warrior(String name, int might, int agility, int intelligence) {
        super(name, might, agility, intelligence);
        this.name = name;
        this.might = 20;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.might);
    }
}
