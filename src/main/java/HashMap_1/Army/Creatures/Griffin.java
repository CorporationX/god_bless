package HashMap_1.Army.Creatures;

import HashMap_1.Army.Creature;

public class Griffin extends Creature {

    public Griffin(int quantity) {
        super("Griffin" ,5, 5, 5, 5, quantity);
    }

    @Override
    public int getDamage(Creature creature) {
        if (creature.getSpeed()<5){
            return -(this.getAttack()*this.getQuantity());
        } else {
            return (this.getAttack()*this.getQuantity())-creature.getDefend();
        }
    }
}
