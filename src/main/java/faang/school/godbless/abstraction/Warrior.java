package faang.school.godbless.abstraction;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        super.attack(character);
        character.health = character.health - this.power;

        System.out.println(character.name + " health > " + character.health);
    }
}
