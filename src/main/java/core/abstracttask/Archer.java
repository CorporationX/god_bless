package core.abstracttask;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
    }
}
