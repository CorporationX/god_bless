package HashMap_1.Army.Creatures;

import HashMap_1.Army.Creature;

public class Pikeman extends Creature {

    public Pikeman(int quantity) {
        super("Pikeman" ,2, 2, 4, 3, quantity);
    }

    @Override
    public int getDamage(Creature creature) {
        if (this.getSpeed()>creature.getSpeed()){
            return -(this.getAttack()*this.getQuantity());
        } else {
            return (this.getAttack()*this.getQuantity())-creature.getDefend();
        }
    }
}
