package ru.kraiush.BJS218953;

import lombok.*;

@Getter
@Setter
@ToString
//@NoArgsConstructor
public class Warrior extends Character {

    private String name;
    private int might = 20;
    private int agility = 5;
    private int intelligence = 3;
    private int health = super.health;

    public Warrior(String name) {
        super(name);
        this.name = name;
    }

    public Warrior(String name, int might, int agility, int intelligence, int health) {
        super(name, might, agility, intelligence, health);
        this.name = name;
        this.might = 20;
        this.agility = 5;
        this.intelligence = 3;
        this.health = super.health;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.might);
    }
}
