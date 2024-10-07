package abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int power, int skill, int intellect) {
        super(name,power, skill, intellect);
    }

    @Override
    public void attack(Character character) {
        character.health = character.health - this.skill;
    }
}
