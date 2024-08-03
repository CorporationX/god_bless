package faang.school.godbless.units;

import java.util.Random;

public class Angel extends Creature{

    public Angel() {
        super("Angel", 7, 20, 20, 12);
    }

    @Override
    public int getDamage() {
        return 50 * this.getAttack() * this.getQuantity();
    }
}
