package abstraction;

public class Archer extends Character {
    {
        this.power = 3;
        this.skill = 10;
        this.intellect = 5;
    }

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int power, int skill, int intellect) {
        super(name, power, skill, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.skill;
    }
}
