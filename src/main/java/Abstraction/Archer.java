package Abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(int strength, int dexterity, int intelligence) {
        super(strength = 3, dexterity = 10, intelligence = 5);
    }

    public void attack(Character character) {
        Warrior.health = Warrior.health - dexterity;

    }
}
