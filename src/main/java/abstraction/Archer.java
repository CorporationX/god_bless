package abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intel = 5;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.dexterity);
    }
}
