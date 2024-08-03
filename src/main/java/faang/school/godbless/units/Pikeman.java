package faang.school.godbless.units;

import java.util.Random;

public class Pikeman extends Creature{

    public Pikeman() {
        super("Pikeman", 1, 4, 5, 4);
    }

    @Override
    public int getDamage() {
        return new Random().nextInt(1,4) * this.getAttack() * this.getQuantity();
    }
}
