package faang.school.godbless.abstraction;


public class Warrior extends Character {

    public Warrior(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        super.attack(character);
        character.health -= this.power;

        System.out.println(character.name + " health > " + character.health);
    }
}
