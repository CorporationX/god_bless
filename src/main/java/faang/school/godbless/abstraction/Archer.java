package faang.school.godbless.abstraction;


public class Archer extends Character {

    public Archer(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }


    @Override
    public void attack(Character character) {
        super.attack(character);
        character.health -= this.dexterity;

        System.out.println(character.name + " health > " + character.health);
    }
}
