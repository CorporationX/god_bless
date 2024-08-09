package faang.school.godbless.basic.abstraction;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.strength = Constants.ARCHER_DEFAULT_STRENGTH;
        this.dexterity = Constants.ARCHER_DEFAULT_DEXTERITY;
        this.intelligence = Constants.ARCHER_DEFAULT_INTELLIGENCE;
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.dexterity;
        System.out.printf("The %s has been bitten with %d dexterity, current health is: %d \n",
                character.name, this.dexterity, character.health);
    }
}
