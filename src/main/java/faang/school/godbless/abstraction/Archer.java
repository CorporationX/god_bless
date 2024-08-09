package faang.school.godbless.abstraction;


public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }


    @Override
    public void attack(Character character) {
        super.attack(character);
        character.health -= this.dexterity;

        System.out.println(character.name + " health > " + character.health);
    }
}
