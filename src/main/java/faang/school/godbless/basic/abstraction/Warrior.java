package faang.school.godbless.basic.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        this.health = this.health - character.strength;
        System.out.printf("The %s has been bitten with %d strength, current health is: %d \n",
                character.name, character.strength, this.health);
    }

}
