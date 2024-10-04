package abstractionAbstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character target) {
        target.hp -= agility;
    }
}
