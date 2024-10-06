package abstractionAbstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(5, 10, 3, name);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - getDexterity());
    }
}
