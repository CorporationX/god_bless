package Abstraction;

public class Archer extends Character{

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(name,10,5,3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
        System.out.println(character.getHealth());
    }
}