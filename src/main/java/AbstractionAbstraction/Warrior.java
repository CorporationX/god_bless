package AbstractionAbstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character character) {
        if(super.getForce()>character.getHealth()) character.setHealth(0);
        character.setHealth((character.getHealth() - super.getForce()));
    }

}
