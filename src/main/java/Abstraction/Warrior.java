package Abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    public Warrior(int strength, int dexterity, int intelligence, int health) {
        super(strength = 10, dexterity = 5, intelligence = 3);
    }

    public void attack(Character character) {
        Archer.health = Archer.health - strength;

    }
}