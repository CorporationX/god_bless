package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.agility;
    }
}
