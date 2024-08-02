package Abstraction;

public class Archer extends Character{

    public Archer(String name) {
        super(name);
        this.dexterity = 10;
        this.intelligence = 5;
        this.strength = 3;
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.health - this.dexterity);
    }
}
