package AbstractionAbstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character character) {
        if(super.getAgility()>character.getHealth()) character.setHealth(0);
        character.setHealth((character.getHealth() - super.getAgility()));
    }
}
