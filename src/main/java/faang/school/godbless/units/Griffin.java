package faang.school.godbless.units;

import java.util.Random;

public class Griffin extends Creature{

    public Griffin() {
        super("Griffin", 3, 8, 8, 6);
    }

    @Override
    public int getDamage() {
        return new Random().nextInt(3,7) * this.getAttack() * this.getQuantity();
    }
}
