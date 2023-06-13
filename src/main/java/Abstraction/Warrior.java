package Abstraction;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(
                name,
                strength = 10,
                dexterity = 5,
                intelligence = 3
        );
    }

    @Override
    public int attack(Character character) {
        int warriorAttack = strength;
        return character.health - warriorAttack;
    }
}