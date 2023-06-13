package Abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, Integer strength, Integer dexterity, Integer intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
        System.out.println(character.getHealth());
    }
}