package faang.school.godbless.units;

import java.util.Random;

public class Swordsman extends Creature{

    public Swordsman() {
        super("Swordsman", 4, 10, 12, 5);
    }

    @Override
    public int getDamage() {
        return new Random().nextInt(6,10) * this.getAttack() * this.getQuantity();
    }
}
