package ru.kraiush.BJS218953;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Archer extends Character {

    private String name;
    private int might;
    private int agility;
    private int intelligence;
    private int health = super.health;

    public Archer(String name) {
        super(name);
        this.name = name;
        might = 3;
        agility = 15;
        intelligence = 5;
    }

    public Archer(String name, int might, int agility, int intelligence) {
        super(name, might, agility, intelligence);
        this.name = name;
        this.might = 3;
        this.agility = 15;
        this.intelligence = 5;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}
