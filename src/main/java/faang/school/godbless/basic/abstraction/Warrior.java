package faang.school.godbless.basic.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = Constants.WARRIOR_DEFAULT_STRENGTH;
        this.dexterity = Constants.WARRIOR_DEFAULT_DEXTERITY;
        this.intelligence = Constants.WARRIOR_DEFAULT_INTELLIGENCE;
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.strength;
        System.out.printf("The %s has been bitten with %d strength, current health is: %d \n",
                character.name, this.strength, character.health);
    }
}
