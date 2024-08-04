package faang.school.godbless.abstractionabstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 6;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
    }
}