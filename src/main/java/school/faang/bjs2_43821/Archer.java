package school.faang.bjs2_43821;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        force = 3;
        agility = 10;
        intellect = 5;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}
