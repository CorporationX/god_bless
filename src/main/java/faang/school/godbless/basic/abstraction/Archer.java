package faang.school.godbless.basic.abstraction;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        this.health = this.health - character.dexterity;
        System.out.printf("The %s has been bitten with %d dexterity, current health is: %d \n",
                character.name, character.dexterity, this.health);
    }
}
