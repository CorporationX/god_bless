package faang.school.godbless.bjs218608;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= strength;
        System.out.println("Warrior attacked... Character -" + strength + " Character's health = " + character.health);
    }
}
