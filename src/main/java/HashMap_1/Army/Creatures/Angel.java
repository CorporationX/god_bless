package HashMap_1.Army.Creatures;

import HashMap_1.Army.Creature;

public class Angel extends Creature {

    public Angel(int quantity) {
        super("Angel" ,10, 10, 10, 10, quantity);
    }

    @Override
    public int getDamage(Creature creature) {
        if (this.getSpeed()>=creature.getSpeed()){
            return -(this.getAttack()*this.getQuantity());
        } else {
            return (this.getAttack()*this.getQuantity())-creature.getDefend();
        }
    }
}
