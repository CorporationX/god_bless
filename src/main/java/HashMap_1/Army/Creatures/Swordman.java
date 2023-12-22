package HashMap_1.Army.Creatures;

import HashMap_1.Army.Creature;

public class Swordman extends Creature {

    public Swordman(int quantity) {
        super("Swordman", 3, 5, 5, 3, quantity);
    }

    @Override
    public int getDamage(Creature creature) {
        return (this.getAttack() * this.getQuantity()) - creature.getDefend();
    }
}
