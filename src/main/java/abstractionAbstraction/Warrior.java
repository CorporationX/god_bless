package abstractionAbstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(3, 5, 10, name);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - getStrength());
    }
}
