package ru.kraiush.BJS218953;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Archer extends Character {

    private String name;
    private int might = 3;
    private int agility = 15;
    private int intelligence = 5;
    private int health = super.health;

    public Archer(String name) {
        super(name);
        this.name = name;
    }

    public Archer(String name, int might, int agility, int intelligence, int health) {
        super(name, might, agility, intelligence, health);
        this.name = name;
        this.might = 3;
        this.agility = 15;
        this.intelligence = 5;
        this.health = super.health;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}

