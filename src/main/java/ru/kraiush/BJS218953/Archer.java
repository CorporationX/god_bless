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
    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}

