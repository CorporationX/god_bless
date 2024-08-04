package faang.school.godbless.abstractionabstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
}