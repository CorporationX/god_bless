package faang.school.godbless.bjs218608;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= agility;
        System.out.println("Archer attacked... Character -" + agility + " Character's health = " + character.health);
    }
}