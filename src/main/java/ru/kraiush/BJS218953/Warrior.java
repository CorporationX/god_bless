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

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.might);
    }
}
